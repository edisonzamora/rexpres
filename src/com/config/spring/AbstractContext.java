package com.config.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public  class  AbstractContext implements ApplicationContextAware {
	
	private static ApplicationContext context;

	protected static ApplicationContext getContext() {
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		AbstractContext.context=applicationContext;
	}

}
