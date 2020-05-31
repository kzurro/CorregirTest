package com.acing.utils;

public class CapitalizarTexto implements ICapitalizarTexto {

	@Override
	public String capitalizar(String str) {

		return (str == null || str.isEmpty()) ? str
				: str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

	}

	
	public CapitalizarTexto() {
		
	}

	
	
}
