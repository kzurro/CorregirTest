package com.acing.examen;

public class Respuesta {

	private int numero;

	private OpcionRespuesta opcionRespuesta;

	public int getNumero() {
		return numero;
	}

	public OpcionRespuesta getRespuesta() {
		return opcionRespuesta;
	}

	protected void setNumero(int numero) {
		this.numero = numero;
	}

	protected void setRespuesta(OpcionRespuesta respuesta) {
		this.opcionRespuesta = respuesta;
	}

	public Respuesta() {
	}

	public Respuesta(int numero, OpcionRespuesta respuesta) {
		setNumero(numero);
		setRespuesta(respuesta);
		;
	}

	@Override
	public String toString() {
		return "Respuesta [getNumero()=" + getNumero() + ", getRespuesta()= " + getRespuesta() +" " + getRespuesta().getClass() +  "]";
	}
	
	

}
