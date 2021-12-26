package com.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.rexpress.common.utils.RexUtil;
import com.rexpress.constants.BeansName;

@Component(BeansName.BEAN_CONFIGAPP)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ConfigApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(ConfigApp.class);

	private String idiomaDefecto;
	
	private ArrayList<String> lisNavIdias = getIdiomasNavegador();
	
	private Locale idiomaApp;

	public void setIdiomaDefecto(String idiomaDefecto) {
		setWebIdiomaDefaultLocale(new Locale(idiomaDefecto));
	}

	public String getIdiomaDefecto() {
		idiomaDefecto = getWebIdiomaDefault();
		return idiomaDefecto;
	}
	
	public void setIdiomaApp(Locale idioma) {
		setWebIdiomaDefaultLocale(idioma);
	}
	public Locale getIdiomaApp() {
		idiomaApp=getWebIdiomaDefaultLocale();
		return idiomaApp;
	}

	/**
	 * devuelve lista de los idiomas del navegador
	 * 
	 * */
	private ArrayList<String> getIdiomasNavegador() {
		FacesContext fct = FacesContext.getCurrentInstance();
		ArrayList<String>lista=(ArrayList<String>) RexUtil.idiomasNavegador(fct);
		
		return lista;
	}

	public ArrayList<String> getLisNavIdia() {
		return lisNavIdias;
	}

	public void setLisNavIdia(ArrayList<String> lisNavIdias) {
		this.lisNavIdias = lisNavIdias;
	}

	/**
	 * @author Edison Zamora
	 * @param FacesContext fct
	 * @return String
	 */
	public String getWebIdiomaDefault(FacesContext fct) {
		fct = FacesContext.getCurrentInstance();
		String idiomaDefectoWeb = fct.getApplication().getDefaultLocale().getLanguage();
		return idiomaDefectoWeb;
	}

	/**
	 * @author Edison Zamora
	 * @param
	 * @return String
	 */
	private  String getWebIdiomaDefault() {
		FacesContext fct=FacesContext.getCurrentInstance();
		String idiomaDefectoWeb = fct.getApplication().getDefaultLocale().getLanguage();
		logger.debug("getWebIdiomaDefault: "+idiomaDefectoWeb);
		return idiomaDefectoWeb;
	}
	
	private void setWebIdiomaDefaultLocale(Locale idioma){
		logger.debug("setWebIdiomaDefaultLocale: "+idioma.getLanguage());

		idioma.getLanguage();
		FacesContext fct = FacesContext.getCurrentInstance();
		fct.getApplication().setDefaultLocale(idioma);
	}
	private Locale getWebIdiomaDefaultLocale(){
		FacesContext fct = FacesContext.getCurrentInstance();
		logger.debug("getWebIdiomaDefaultLocale: "+fct.getApplication().getDefaultLocale().getLanguage());
		return fct.getApplication().getDefaultLocale();

	}

	

}
