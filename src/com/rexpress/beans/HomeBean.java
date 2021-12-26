package com.rexpress.beans;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.rexpress.constants.BeansName;

@Component(BeansName.BEAN_HOMEBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class HomeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String buscador;
	
	public String getBuscador() {
		return buscador;
	}

	public HomeBean() {
		
	}

	public void setBuscador(String buscado) {
		this.buscador = buscado;
	}


}
