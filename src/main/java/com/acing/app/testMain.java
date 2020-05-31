package com.acing.app;

public class testMain {

	public static void main(String[] args) {
		String nombre = " hola  me llamo pepito hola";
		
		System.out.println("sin poner metodo " + nombre.indexOf("."));
		
		//System.out.println(getOpcionRespuesta(nombre).length());
	}
	
	public static String getOpcionRespuesta(String string) {
		int indice = string.indexOf(".");
		
		return string.substring(0, indice).replace(" ", "");
	}
	

	
}
