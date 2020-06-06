package com.acing.examen;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluacion implements Evaluable{

	private String nombre;

	private List<Respuesta> preguntas;

	public String getNombre() {
		return nombre;
	}

	public List<Respuesta> getPreguntas() {
		return preguntas;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setPreguntas(List<Respuesta> preguntas) {
		if (this.preguntas == null) {
			this.preguntas = new ArrayList<>();
			this.preguntas.addAll(preguntas);
		} else {
			this.preguntas.addAll(preguntas);
		}
	}

	public Evaluacion() {
		this.preguntas = new ArrayList<>();
		
	}
	
	public Evaluacion(String nombre, List<Respuesta> preguntas) {
		setNombre(nombre);
		setPreguntas(preguntas);
	}
	
	

}
