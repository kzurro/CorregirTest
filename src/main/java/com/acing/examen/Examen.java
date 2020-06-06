package com.acing.examen;

import java.util.List;

public class Examen extends Evaluacion {

	public Examen() {
		super();
	}

	public Examen(String nombre, List<Respuesta> preguntas) {
		super(nombre, preguntas);
	}

	public String getRespuestas(List<Respuesta> respuestas) {
		String todo = "";

		for (int i = 0; i < respuestas.size(); i++) {
			todo += "   " + (i + 1) + " ==>  "
					+ (respuestas.get(i).getRespuesta().equals(OpcionRespuesta.No_Responde) ? "N/C"
							: respuestas.get(i).getRespuesta() + "  ");

		}

		return todo;
	}

	@Override
	public String toString() {
		return completarHastaOcho(getNombre()) + getRespuestas(getPreguntas());
	}

	/*
	 * @kzurro he optado que el código de alumno va a ser como máximo hasta 8
	 * carcateres(DNI)
	 */
	public String completarHastaOcho(String s) {
		String completado = s;
		for (int i = s.length(); i <= 8; i++) {
			completado += " ";
		}

		return completado;
	}

}
