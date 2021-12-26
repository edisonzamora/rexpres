package com.rexpress.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.config.ConfigApp;
import com.rexpress.constants.BeansName;


@Component(BeansName.BEAN_LOGINBEAN)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private ConfigApp configApp;
	
	private String correo;
	
	private String password;
	
	private String idioma;
	
	private ArrayList<SelectItem>idiomas;
	
	public ArrayList<SelectItem> getIdiomas() {
		idioma=idioma!=null ? idioma : "";
		idiomas=listIdioma();
		return idiomas;
	}
	public void setIdiomas(ArrayList<SelectItem> idiomas) {
		this.idiomas = idiomas;
	}
	private ArrayList<SelectItem> listIdioma() {
		configApp.getLisNavIdia();
		return arrayListToSelectetList(configApp.getLisNavIdia());
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		if(!getIdioma().equals("")){
			configApp.setIdiomaDefecto(idioma);
		}
		this.idioma = idioma;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private ArrayList<SelectItem> arrayListToSelectetList( ArrayList<String> list){
		ArrayList<SelectItem>listSelectet=new ArrayList<SelectItem>();
		for (String valor : list) {
			
			listSelectet.add(new SelectItem(valor, valor));
		}
		return listSelectet;
	}
	
	
}
