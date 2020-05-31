package com.acing.examen;

import java.util.List;

public class Plantilla extends Evaluacion {
	
	private String asigantura;
	
	private int numeroDistractores;

	
	
	public String getAsigantura() {
		return asigantura;
	}



	private void setAsigantura(String asigantura) {
		this.asigantura = asigantura;
	}


	

	public int getNumeroDistractores() {
		return numeroDistractores;
	}



	private void setNumeroDistractores(int numeroDistractores) {
		this.numeroDistractores = numeroDistractores;
	}



	public Plantilla() {
		super();
	}



	public Plantilla(String nombre, int numeroDistractores, List<Respuesta> preguntas, String asigantura) {
		super(nombre, preguntas);
		setAsigantura(asigantura);
		setNumeroDistractores(numeroDistractores);
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
		return getNombre() + " ===>" + getAsigantura() + ",  " + getNumeroDistractores()
				+ " Distractores"+  ", Respuestas Correctas" + getRespuestas(getPreguntas());
	}
	
	
	
	
	

}
