package com.rexpress.controllers;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.LoginBean;
import com.rexpress.beans.UserBean;
import com.rexpress.constants.BeansName;
import com.rexssecurity.Role;

@Controller
@Component(BeansName.BEAN_LOGINCONTROLLERBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class LoginController extends CommonController implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
//	@Autowired
//	private UsuaioService usuService;

	private boolean allMesseng = false;

	public boolean isAllMesseng() {
		return allMesseng;
	}

	public void setAllMesseng(boolean allMesseng) {
		this.allMesseng = allMesseng;
	}

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	private static final String LOGINVIEW = "loginView";

	private static final String HOMEVIEW = "homeView";

	public String aceptar() {
		getLoger().info("loginContollerbean.aceptar");
		UserBean userbean;
		LoginBean login = (LoginBean) getBean("loginbean");
		if (!isEnty(login)) {
			userbean=new UserBean();
			userbean.setCorreo(remplazaEspacio(login.getCorreo()));
			userbean.setPassword(remplazaEspacio(login.getPassword()));
			userbean.setActivo(1);
			userbean.setNombre("Edison");
			userbean.setCorreo("Zamora");
			userbean.setRole(Role.ADM);
			userbean.setIdioma(login.getIdioma());
			logger.debug("Nombre Usuario=" + userbean.getNombre());
			FacesContext cx=getFacesContext();
			((HttpSession) cx.getExternalContext().getSession(false)).setAttribute("userbean", userbean);
			return "security/" + HOMEVIEW + "?faces-redirect=true";
			// buscamos si el correo existe, sino existe informamos con un
			// warnig
			// if (null != usuService.UsuarioByCorreo(userbean)) {
			// // validamo si el pass del correo coinside con el ingresado
			// if (login.getPassword().equals(userbean.getPassword())) {
			// HttpSession session = (HttpSession)
			// ctx.getExternalContext().getSession(false);
			// session.setAttribute("usuario", userbean);
			// // Connection con=bs.getConnection();
			// return "security/" + HOMEVIEW + "?faces-redirect=true";
			// } else {
			// logger.debug("El password no corresponde a este correo");
			// String msg = ctx.getApplication().getResourceBundle(ctx,
			// "msg").getString("msg_err_usu_pass_no_coinside");
			// ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
			// "info",msg ));
			// login.setCorreo("");
			// login.setPassword("");
			// return LOGINVIEW;
			// }
			//
			// } else {
			// logger.debug("Correo de usuario no encontrado");
			// String msg = ctx.getApplication().getResourceBundle(ctx,
			// "msg").getString("msg_err_usu_no_encontrado");
			// ctx.addMessage("msg", new
			// FacesMessage(FacesMessage.SEVERITY_INFO, "info:", msg));
			// login=null;
			// return LOGINVIEW;
			//
			// }
		} else {
			logger.debug("caracteres con espacio");
			login = null;
			addMessengError(getProperty("msg_err_caracter", "msg"));
			return LOGINVIEW;
		}
	}

	private String remplazaEspacio(String valor) {
		String sinEspacio = valor.replace(" ", "");
		sinEspacio = sinEspacio.trim();
		return sinEspacio;
	}

	private boolean isEnty(LoginBean loginBean) {
		if (loginBean.getCorreo().equals("") || loginBean.getCorreo().equals(" ")) {
			return true;

		}
		if (loginBean.getPassword().equals("") || loginBean.getCorreo().equals(" ")) {
			return true;
		}

		return false;

	}
}