package com.acing.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.acing.examen.CorregibleImpl;
import com.acing.examen.Evaluado;
import com.acing.examen.Examen;
import com.acing.examen.GestorCorrecion;
import com.acing.examen.Plantilla;
import com.acing.excel.Notas;
import com.acing.serial.SerializadorCSV;

public class App {

	public static void main(String[] args) throws IOException {

		/*
		 * METODO QUE ARRANCA TODA LA APLICACIÓN PARA OBTENER EL archivo .xlsx con los
		 * resultados del test
		 */
		getNotas();
	}

	/*
	 * Método que sirve pra obtener el nombre de los archivos a serializar, con el
	 * quitamos la ectensióon y devolvemos el nombre
	 */
	private static String getNombre(String string) {
		String opcion = "";
		int indice = string.length();
		if (string.indexOf(".") != -1) {
			indice = string.indexOf(".");
		}
		return string.substring(0, indice).replace(" ", "");

	}

	/**
	 * @author kzurro metodo que busca los arhivos en la carpeta data/ y alimenta
	 *         los serializadores , gestor de correccion y el generador de notas en
	 *         archvi .xlsx.  El boolean alu,jar  están para que el sereializador tenga en cuenta o no que
	 *         existe, el archivo .alu o .jar , asi lo convertimos en no es obligatorio el alu y al ejecutar obvia los ejecutables
	 */
	private static void getNotas() throws IOException {
		String rutaString = "data/";
		boolean alu = false;
		boolean jar = false;
		int indiceJar = 0;
		List<String> strings = new ArrayList<>();

		Files.walk(Paths.get(rutaString)).forEach(ruta -> {

			if (Files.isRegularFile(ruta)) {
				strings.add(ruta.getFileName().toString());
			}
		});


		for (String s : strings) {
			if (s.endsWith(".alu")) {
				alu = true;
			}
			if (s.endsWith(".jar"))  {
				jar = true;
				indiceJar = strings.indexOf(s);
			}
			
		}
		
		if (jar) strings.remove(indiceJar);
	

		rutaString = rutaString + getNombre(strings.get(0));
		GestorCorrecion gestor = new GestorCorrecion();

		Plantilla plantilla;

		SerializadorCSV serializadorCSV = new SerializadorCSV();

		plantilla = serializadorCSV.getPlantilla(rutaString + ".pla");
		System.out.println(plantilla.toString());

		List<Examen> examenes = new ArrayList<>();
		examenes = serializadorCSV.getEvaluables(rutaString + ".csv");
		for (Examen e : examenes) {
			System.out.println(e.toString());
		}

		List<Evaluado> evaluados;// = new ArrayList<>();

		evaluados = alu ? serializadorCSV.getEvaluados(rutaString + ".alu") : new ArrayList<>();

		List<CorregibleImpl> resultados = gestor.getCorreccionesEnClaro(plantilla, examenes, evaluados);

		for (CorregibleImpl c : resultados) {
			System.out.println(c.getNombre() + " ===> " + c.getNota());
		}

		Notas notas = new Notas();

		try {
			notas.setHojaCalificaciones(plantilla, resultados);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("Error al general el listado");
		}
		System.out.println(
				"==================================================================FIN==================================================================");

	}

}
