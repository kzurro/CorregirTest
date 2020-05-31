package com.acing.utils;


/**
 * @author kzurro
 *
 *Clase para capitalizar texto
 *Queda pendiente capitalizar cualquier tipo de string como nombre y apellidos
 */
public class CapitalizarTexto implements ICapitalizarTexto {

	@Override
	public String capitalizar(String str) {

		return (str == null || str.isEmpty()) ? str
				: str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

	}

	
	public CapitalizarTexto() {
		
	}

	
	
}
