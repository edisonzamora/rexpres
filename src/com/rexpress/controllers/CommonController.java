package com.rexpress.controllers;

import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.config.AbstractController;

public class CommonController extends AbstractController {
	
	private FacesContext facesContext;
	
	private Logger logger;
	
	@Override
	public FacesContext getFacesContext() {
	    facesContext=FacesContext.getCurrentInstance();
		return facesContext;
	}

	@Override
	protected Logger getLoger() {
		logger= LogManager.getLogger(this);
			return logger;
		}
	}
	

