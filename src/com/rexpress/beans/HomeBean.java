package com.rexpress.beans;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rexpress.constant.BeansName;

@Component(BeansName.BEAN_HOMEBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class HomeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String buscador;

	public UserBean getUserBeanHome() {
		return userBeanHome;
	}

	public void setUserBeanHome(UserBean userBeanHome) {
		this.userBeanHome = userBeanHome;
	}

	private UserBean userBeanHome;
	
	public String getBuscador() {
		return buscador;
	}

	public HomeBean() {
		
	}

	public void setBuscador(String buscado) {
		this.buscador = buscado;
	}


}
