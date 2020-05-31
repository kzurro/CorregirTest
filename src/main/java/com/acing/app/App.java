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

		 getNotas();
	}
		
	private static String getNombre(String string) {
		String opcion = "";
		int indice = string.length();
		if (string.indexOf(".") != -1) {
			indice = string.indexOf(".");
		}
		return string.substring(0, indice).replace(" ", "");

	}


	private static void getNotas() throws IOException {
		String string = "";
		boolean alu = false;
		List<String> strings = new ArrayList<>();

		Files.walk(Paths.get("C:\\desarrollo\\testCorreccion\\data")).forEach(ruta -> {

			if (Files.isRegularFile(ruta)) {
				strings.add(ruta.getFileName().toString());			
			}
		});
		
		for(String s: strings) {
			if (s.endsWith(".pla")) {
				alu = true;
			}
		}
		//strings.remove(strings.indexOf("corregir.jar"));
		
	
		string = "data/";
		string = string + getNombre(strings.get(0));

		GestorCorrecion gestor = new GestorCorrecion();

		Plantilla plantilla;

		SerializadorCSV serializadorCSV = new SerializadorCSV();

		plantilla =  serializadorCSV.getPlantilla(string + ".pla");

		List<Examen> examenes = new ArrayList<>();
		examenes = serializadorCSV.getEvaluables(string + ".csv");
		System.out.println(plantilla.toString());

		List<Evaluado> evaluados = new ArrayList<>();

		evaluados = alu? serializadorCSV.getEvaluados(string + ".alu") : null;

	

		List<CorregibleImpl> resultados = gestor.getCorreccionesEnClaro(plantilla, examenes, evaluados);
		
		for(CorregibleImpl c: resultados) {
			System.out.println(c.getNombre() + " ===> "+ c.getNota());
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
