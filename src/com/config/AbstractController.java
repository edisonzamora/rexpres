package com.config;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.Logger;
import com.config.spring.ApplicationRexpressContext;

public abstract class AbstractController  {
	
	protected abstract  FacesContext getFacesContext();
	
	protected  abstract Logger  getLoger();
	
	protected  Object getBean(String beanName){
		return ApplicationRexpressContext.getContexto().getBean(beanName);
	}
	
	protected  Object getBean(String beanName , Object arg){
		return ApplicationRexpressContext.getContexto().getBean(beanName, arg);
	}
	
	protected  <T> T getBean(Class<T> requiredType){
		return ApplicationRexpressContext.getContexto().getBean(requiredType);
	}
	
	protected String getProperty(String key , String var){
		FacesContext fctx=getFacesContext();
		return fctx.getApplication().getResourceBundle(fctx, var).getString(key);
	}
	
	protected void addMessengError ( String mensaje){
		FacesContext fctx=getFacesContext();
		fctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null));
	}
	protected void addMessengInfo ( String mensaje){
		FacesContext fctx=getFacesContext();
		fctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, null));
	}
	protected void addMessengWarn ( String mensaje){
		FacesContext fctx=getFacesContext();
		fctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, null));
	}
	protected void addMessengFatal ( String mensaje){
		FacesContext fctx=getFacesContext();
		fctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, null));
	}
 
}
