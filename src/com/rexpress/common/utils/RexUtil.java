package com.rexpress.common.utils;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class RexUtil {

	public static List<String> idiomasNavegador(FacesContext fct) {

		String navIdiona = ((HttpServletRequest) fct.getExternalContext().getRequest()).getHeader("Accept-Language");

		return idiomasNavegador(navIdiona);
	}

	private static List<String> idiomasNavegador(String indiomas) {

		ArrayList<String> listaPrefijo = new ArrayList<>();

		String[] list = StringUtils.split(indiomas, ",");

		for (int x = 0; x < list.length; x++) {
			if (list[x].indexOf(";") != -1) {
				String[] list2 = StringUtils.split(list[x], ";");
				listaPrefijo.add(list2[0]);
			} else {
				listaPrefijo.add(list[x]);
			}
		}

		return listaPrefijo;
	}
	
	
	public static FacesContext fcCuCurrentInstance(){
		return FacesContext.getCurrentInstance();
	}
	
	
}
