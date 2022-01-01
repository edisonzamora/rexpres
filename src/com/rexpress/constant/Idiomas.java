package com.rexpress.constant;

public enum Idiomas {
	ES("es"), EN("en");
	
	private String idioma;

	private Idiomas(String prefijo) {
		this.idioma = prefijo;
	}

	public String getIdima() {
		return idioma;
	}
}
