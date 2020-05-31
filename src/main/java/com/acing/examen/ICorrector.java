package com.acing.examen;

import java.util.List;

public interface ICorrector {

	public TipoRespuesta isCorrecta(OpcionRespuesta corrector, OpcionRespuesta respuesta);

	public <T extends Evaluable> boolean isPlantilla(Class<T> tipo);

	public <P extends ICorregible, T extends Evaluable> P getCorreccion(T plantilla, T examen);

	public CorregibleImpl getCorreccion(Plantilla plantilla, Examen examen, List<Evaluado> evaluados);

	public List<? extends ICorregible> getCorrecciones(Plantilla plantilla, List<Examen> examenes);

	public List<? extends ICorregible> getCorreccionesEnClaro(Plantilla plantilla, List<Examen> examenes,
			List<Evaluado> evaluados);

}
