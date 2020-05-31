package com.acing.examen;

public class Evaluado {

	private String codigo;
	private String nombre;

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Evaluado() {

	}

	public Evaluado(String codigo, String nombre) {
		setCodigo(codigo);
		setNombre(nombre);
	}

	@Override
	public String toString() {
		return "Evaluado [getCodigo()=" + getCodigo() + ", getNombre()=" + getNombre() + "]";
	}
	
	

}
