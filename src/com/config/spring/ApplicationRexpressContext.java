package com.config.spring;

import org.springframework.context.ApplicationContext;

public class ApplicationRexpressContext extends AbstractContext {

	private static ApplicationContext contex;

	public static ApplicationContext getContexto() {
		contex = getContext();
		return contex;
	}



}
