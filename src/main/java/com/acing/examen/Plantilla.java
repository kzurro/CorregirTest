package com.acing.examen;

import java.util.List;

public class Plantilla extends Evaluacion {

	private String asigantura;

	private int numeroDistractores;

	private boolean cuentanErrores;

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

	public boolean isCuentanErrores() {
		return cuentanErrores;
	}

	private void setCuentanErrores(boolean cuentanErrores) {
		this.cuentanErrores = cuentanErrores;
	}

	public Plantilla() {
		super();
	}

	public Plantilla(String nombre, int numeroDistractores, List<Respuesta> preguntas, String asigantura) {
		super(nombre, preguntas);
		setAsigantura(asigantura);
		setNumeroDistractores(numeroDistractores);
	}

	public Plantilla(String nombre, String asignatura, List<Respuesta> preguntas, int numeroDistractores,
			boolean cuentanErrores) {
		super(nombre, preguntas);
		setAsigantura(asignatura);
		setNumeroDistractores(numeroDistractores);
		setCuentanErrores(cuentanErrores);
	}

	public String getRespuestas(List<Respuesta> respuestas) {
		String todo = "";

		for (int i = 0; i < respuestas.size(); i++) {
			todo += " " + (i + 1) + " ==>  " + respuestas.get(i).getRespuesta() + "    ";

		}

		return todo;
	}

	@Override
	public String toString() {
		return getAsigantura() + " ===> " + getNumeroDistractores() + " Distractores" + ", Cuentan errores: "
				+ isCuentanErrores() + ".\nR.Correctas" + getRespuestas(getPreguntas());
	}

}
