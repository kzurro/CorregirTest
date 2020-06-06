package com.acing.examen;

public class CorregibleImpl implements ICorregible {

	private String nombre;
	private int aciertos;
	private int errores;
	private int noContestadas;
	private double nota;

	public String getNombre() {
		return nombre;
	}

	public int getAciertos() {
		return aciertos;
	}

	public int getErrores() {
		return errores;
	}

	public int getNoContestadas() {
		return noContestadas;
	}

	public double getNota() {
		return nota;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	protected void setErrores(int errores) {
		this.errores = errores;
	}

	protected void setNoContestadas(int noContestadas) {
		this.noContestadas = noContestadas;
	}

	protected void setNota(double nota) {
		this.nota = nota;
	}

	public CorregibleImpl() {
	}

	public CorregibleImpl(int aciertos, int errores, int noContestadas, double nota, String nombre) {
		setAciertos(aciertos);
		setErrores(errores);
		setNoContestadas(noContestadas);
		setNota(nota);
		setNombre(nombre);
	}

	public static double formatearDecimales(double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

	@Override
	public int getPreguntas() {
		return (getAciertos() + getErrores() + getNoContestadas());
	}

	@Override
	public void setCorreccionConErrores(int numDistractores) {
		double nota = (getAciertos() - (getErrores() / (numDistractores - 1)))
				* (10.0 / (getAciertos() + getErrores() + getNoContestadas()));

		setNota(formatearDecimales(nota, 3));

	}

	@Override
	public void setCorrecionSinErrores(int numDistractores) {
		double nota = getAciertos() * (10.0 / (getAciertos() + getErrores() + getNoContestadas()));

		setNota(formatearDecimales(nota, 3));

	}

	@Override
	public void setCorrecion(int numDistractores, boolean cuentanFallos) {
		if (cuentanFallos) {
			setCorreccionConErrores(numDistractores);
		}else {
			setCorrecionSinErrores(numDistractores);
		}

	}

}
