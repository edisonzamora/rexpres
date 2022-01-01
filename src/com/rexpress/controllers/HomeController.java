package com.rexpress.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.beans.UserBean;
import com.rexpress.constant.BeansName;
import com.rexssecurity.services.UsuaioService;

@Controller
@Component(BeansName.BEAN_HOMECONTROLLERBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class HomeController extends CommonController implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Autowired
	private UsuaioService usuService;
	
	@Autowired
	private UserBean usu;
	
	private ArrayList<UserBean>listaUsuariosBean;
		
	private  final String HOMEVIEW = "homeView";
	private  final String LOGINVIEW = "loginView";

	
	public String cerrarSesion(){
			FacesContext ctx = getFacesContext();
			HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
			usu.getApellido();
			session.removeAttribute("userbean");
			session.invalidate();
			return "../"+LOGINVIEW+".xhtml?faces-redirect=true";
	}
	
	public ArrayList<UserBean> getListaUsuariosBean() {
		listaUsuariosBean=null;
		listaUsuariosBean=usuService.listaUsuarios();
		return listaUsuariosBean;
	}

	public void setListaUsuariosBean(ArrayList<UserBean> listaUsuariosBean) {
		this.listaUsuariosBean = listaUsuariosBean;
	}

}
