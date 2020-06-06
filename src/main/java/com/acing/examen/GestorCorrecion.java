package com.acing.examen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kzurro
 * 
 *         Clase core de la aplicación con los metodos para corregir los
 *         examenes obtenidos y poniendo asigando nombre a cada alumnos
 */
public class GestorCorrecion implements ICorrector {

	@Override
	public TipoRespuesta isCorrecta(OpcionRespuesta corrector, OpcionRespuesta respuesta) {
		TipoRespuesta tipoRespuesta = TipoRespuesta.noContestada;
		if (corrector == respuesta) {
			tipoRespuesta = TipoRespuesta.correcta;
		}
		if (corrector != respuesta && respuesta != null) {
			tipoRespuesta = TipoRespuesta.incorrecta;
		}

		return tipoRespuesta;
	}

	@Override
	public CorregibleImpl getCorreccion(Evaluable plantilla, Evaluable examen) {
		CorregibleImpl correccion = new CorregibleImpl();
		int aciertos = 0;
		int errores = 0;
		int noContestadas = 0;
		int preguntas = ((Plantilla) plantilla).getPreguntas().size();

		List<Respuesta> rPlantilla = ((Plantilla) plantilla).getPreguntas();
		List<Respuesta> rExamen = ((Examen) examen).getPreguntas();

		for (int i = 0; i < preguntas; i++) {
			if (OpcionRespuesta.No_Responde == rExamen.get(i).getRespuesta()) {
				noContestadas++;
			} else if (rExamen.get(i).getRespuesta().equals(rPlantilla.get(i).getRespuesta())) {
				aciertos++;
			} else {
				errores++;
			}
		}

		correccion.setNombre(((Examen) examen).getNombre());
		correccion.setAciertos(aciertos);
		correccion.setErrores(errores);
		correccion.setNoContestadas(noContestadas);
		// correccion.setCorreccionConErrores(((Plantilla)
		// plantilla).getNumeroDistractores());
		correccion.setCorrecion(((Plantilla) plantilla).getNumeroDistractores(),
				((Plantilla) plantilla).isCuentanErrores());

		if (preguntas != correccion.getPreguntas()) {
			correccion = new CorregibleImpl(0, 0, 0, 0, "ERROR CORRECCIÓN");
		}

		return correccion;
	}

	@Override
	public CorregibleImpl getCorreccion(Plantilla plantilla, Examen examen, List<Evaluado> evaluados) {
		CorregibleImpl correccion = getCorreccion(plantilla, examen);
		for (Evaluado e : evaluados) {
			if (examen.getNombre().equals(e.getCodigo())) {
				correccion.setNombre(e.getNombre());
			}
		}

		return correccion;
	}

	@Override
	public List<CorregibleImpl> getCorrecciones(Plantilla plantilla, List<Examen> examenes) {
		List<CorregibleImpl> correcciones = new ArrayList<>();
		for (Examen e : examenes) {
			correcciones.add(getCorreccion(plantilla, e));
		}
		return correcciones;
	}

	@Override
	public List<CorregibleImpl> getCorreccionesEnClaro(Plantilla plantilla, List<Examen> examenes,
			List<Evaluado> evaluados) {
		List<CorregibleImpl> correcciones = new ArrayList<>();
		for (Examen e : examenes) {
			correcciones.add(getCorreccion(plantilla, e, evaluados));
		}
		return correcciones;
	}

	@Override
	public <T extends Evaluable> boolean isPlantilla(Class<T> tipo) {
		return false;
	}

}
