package com.acing.serial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.acing.examen.Evaluado;
import com.acing.examen.Examen;
import com.acing.examen.OpcionRespuesta;
import com.acing.examen.Plantilla;
import com.acing.examen.Respuesta;

/**
 * @author kzurro
 *
 *         Clase para generar los distintos sereializadores que hacen falta para
 *         recoger los datos para generar el excel
 */
public class SerializadorCSV {

	public SerializadorCSV() {
	}

	/**
	 * @author kzurro
	 *
	 *         Metodo para obtener los examenes
	 */
	public static List<Examen> getEvaluables(String rutaArchivo) {
		List<Examen> evaluablesLeidos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8"))) {

			String linea = reader.readLine();
			while ((linea = reader.readLine()) != null) {
				evaluablesLeidos.add(deserializarEvaluables(linea));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return evaluablesLeidos;
	}

	/**
	 * @author kzurro
	 *
	 *         Metodo para obtener los evaluados
	 */

	public static List<Evaluado> getEvaluados(String rutaArchivo) {
		List<Evaluado> evaluadosLeidos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8"))) {

			String linea = reader.readLine();
			while ((linea = reader.readLine()) != null) {
				evaluadosLeidos.add(deserializarEvaluados(linea));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return evaluadosLeidos;
	}

	/**
	 * @author kzurro
	 *
	 *         Metodo que va cogiendo linea por linea el para codigo, alumnos. Se le
	 *         pued epasar "codAnumno;nombre" o "codAlumno,nombre"
	 */
	private static Evaluado deserializarEvaluados(String linea) {
		linea = linea.replace("\"", "");
		String[] campos = linea.indexOf(";") != -1 ? linea.split(";") : linea.split(",");
		String codigo = campos[0];
		String nombre = campos[1];
		Evaluado evaluado = new Evaluado(codigo, nombre);
		return evaluado;
	}

	/**
	 * @author kzurro
	 *
	 *         Metodo que construye la plantilla
	 */
	public static Plantilla getPlantilla(String rutaArchivo) {

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(rutaArchivo), "UTF-8"))) {

			String linea = reader.readLine();
			linea = linea.replace("\"", "");
			String[] campos = linea.split(",");
			String asignatura = campos[0];
			String numeroDistractoresString = campos[1];
			int numeroDistractores = Integer.parseInt(numeroDistractoresString);
			List<Respuesta> preguntas = new ArrayList<>();
			for (int i = 2; i < campos.length; i++) {
				String opcion = campos[i];
				OpcionRespuesta opcionRespuesta = OpcionRespuesta.valueOf(opcion);
				Respuesta respuesta = new Respuesta(i - 1, opcionRespuesta);
				preguntas.add(respuesta);
			}
			Plantilla plantilla = new Plantilla("plantilla", numeroDistractores, preguntas, asignatura);
			return plantilla;
		} catch (Exception e) {
			e.printStackTrace();
			return new Plantilla();
		}

	}

	/**
	 * @author kzurro
	 *
	 *         Metodo que va construyendo Examen por cada linbea que se serializa
	 */
	private static Examen deserializarEvaluables(String linea) {
		linea = linea.replace(",\"", "¥\"");
		linea = linea.replace("\"", "");
		String[] campos = linea.split("¥");
		String nombre = campos[0];
		List<Respuesta> respuestas = new ArrayList<>();
		for (int i = 1; i < campos.length; i++) {
			campos[i] = getOpcionRespuesta(campos[i]);
			String opcion;
			OpcionRespuesta opcionRespuesta;
			if (campos[i] == null || campos[i] == "No Contestada") {
				opcionRespuesta = OpcionRespuesta.No_Responde;
			} else {
				opcion = campos[i];
				opcionRespuesta = OpcionRespuesta.valueOf(opcion);
			}

			Respuesta respuesta = new Respuesta(i, opcionRespuesta);
			respuestas.add(respuesta);
		}

		Examen examen = new Examen(nombre, respuestas);

		return examen;
	}

	/**
	 * @author kzurro
	 *
	 *         metodo para obtener el tipo de distractor y obviar el texto que le
	 *         sigue
	 */
	private static String getOpcionRespuesta(String string) {
		String opcion = "";
		int indice = string.length();
		if (string.indexOf(".") != -1) {
			indice = string.indexOf(".");
		}
		return string.substring(0, indice).replace(" ", "");

	}

}
