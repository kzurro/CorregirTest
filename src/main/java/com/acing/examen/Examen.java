package com.acing.examen;

import java.util.List;

public class Examen extends Evaluacion{

	public Examen() {
		super();
	}

	public Examen(String nombre, List<Respuesta> preguntas) {
		super(nombre, preguntas);
	}
	
	
	public String getRespuestas(List<Respuesta> respuestas) {
		String todo ="";
		
		for (int i = 0; i < respuestas.size(); i++) {
			todo += "     " + (i + 1)  + " ==>  " +  respuestas.get(i).getRespuesta();
			
		}
		
		return todo;
	}

	@Override
	public String toString() {
		return  getNombre() + getRespuestas(getPreguntas());
	}
	
	
	
	
	
	
	

}
