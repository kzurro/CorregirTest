package com.acing.examen;

public interface ICorregible {
	
	public void setCorreccionConErrores(int numDistractores);
	
	public void setCorrecionSinErrores( int numDistractores);
	
	public void setCorrecion(int numDistractores, boolean cuentanFallos);
	
	public int getPreguntas();

}
