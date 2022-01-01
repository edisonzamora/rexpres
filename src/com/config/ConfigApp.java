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
import com.rexpress.constant.BeansName;

@Component(BeansName.BEAN_CONFIGAPP)
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class ConfigApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(ConfigApp.class);

	private String idiomaDefecto;
	
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
	 * @author Edison Zamora
	 * @param FacesContext fct
	 * @return String
	 */
	public String getWebIdiomaDefault(FacesContext fct) {
		String idiomaDefectoWeb = RexUtil.fcCuCurrentInstance().getApplication().getDefaultLocale().getLanguage();
		return idiomaDefectoWeb;
	}

	/**
	 * @author Edison Zamora
	 * @param
	 * @return String
	 */
	private  String getWebIdiomaDefault() {
		String idiomaDefectoWeb = RexUtil.fcCuCurrentInstance().getApplication().getDefaultLocale().getLanguage();
		logger.debug("getWebIdiomaDefault: "+idiomaDefectoWeb);
		return idiomaDefectoWeb;
	}
	
	private void setWebIdiomaDefaultLocale(Locale idioma){
		logger.debug("setWebIdiomaDefaultLocale: "+idioma.getLanguage());
		RexUtil.fcCuCurrentInstance().getApplication().setDefaultLocale(idioma);
	}
	
	private Locale getWebIdiomaDefaultLocale(){
		logger.debug("getWebIdiomaDefaultLocale: "+RexUtil.fcCuCurrentInstance().getApplication().getDefaultLocale().getLanguage());
		return RexUtil.fcCuCurrentInstance().getApplication().getDefaultLocale();

	}
	

}
