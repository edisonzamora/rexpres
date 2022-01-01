package com.rexpress.controllers;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.HomeBean;
import com.rexpress.beans.LoginBean;
import com.rexpress.beans.UserBean;
import com.rexpress.constant.BeansName;
import com.rexpress.constant.Views;
import com.rexssecurity.Role;
import com.rexssecurity.entitys.Usuario;
import com.rexssecurity.services.UsuaioService;

@Controller
@Component(BeansName.BEAN_LOGINCONTROLLERBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class LoginController extends CommonController implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuaioService usuService;

	@Autowired
	private UserBean usurioBean;

	@Autowired
	private LoginBean loginBean;

	private boolean allMesseng = false;

	public boolean isAllMesseng() {
		return allMesseng;
	}

	public void setAllMesseng(boolean allMesseng) {
		this.allMesseng = allMesseng;
	}

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	public String aceptar() {
		getLoger().info("loginContollerbean.aceptar");
		UserBean userbean = new UserBean();

		userbean.setCorreo(loginBean.getCorreo());
		userbean = usuService.UsuarioByCorreo(userbean);

		if (userbean == null) {
			return Views.Views_LoginView;
		} else {
			if (userbean.getPassword().equalsIgnoreCase(loginBean.getPassword())) {
				usurioBean = userbean;
				logger.debug("Nombre Usuario=" + usurioBean.getNombre());
				logger.debug("Nombre Apellido=" + usurioBean.getApellido());
				logger.debug("Nombre Correo=" + usurioBean.getCorreo());
				logger.debug("Nombre Idioma=" + usurioBean.getIdioma());
				logger.debug("Nombre Estado=" + usurioBean.getActivo());
				logger.debug("Nombre Role=" + usurioBean.getRole());

				HomeBean homeBean = (HomeBean) getBean("homebean");
				homeBean.setUserBeanHome(usurioBean);
				FacesContext cx = getFacesContext();
				((HttpSession) cx.getExternalContext().getSession(false)).setAttribute("userbean", usurioBean);
				return "security/" + Views.Views_HomeView + "?faces-redirect=true";
			}
			return Views.Views_LoginView;

		}

	}
}