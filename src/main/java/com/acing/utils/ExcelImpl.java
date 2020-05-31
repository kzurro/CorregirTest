package com.acing.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.acing.examen.Plantilla;





public class ExcelImpl implements IExcel {

	private final String carpetaExcel = "";

	public String getCarpetaExcel() {
		return carpetaExcel;
	}

	@Override
	public XSSFWorkbook getExcel() {

		return new XSSFWorkbook();
	}

	@Override
	public FileOutputStream getCierreExcel(XSSFWorkbook workbook, Plantilla plantilla) throws IOException {
		FileOutputStream out = new FileOutputStream(
				new File(getCarpetaExcel() + getNombreArchivo(plantilla) + ".xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Generada Notas " + getNombreArchivo(plantilla) + ".xlsx");
		return out;
	}

	@Override
	public Calendar getFecha() {
		return Calendar.getInstance();
	}

	@Override
	public String getFechaFormateada() {
		String month = getFecha().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		int day = getFecha().get(Calendar.DAY_OF_MONTH);
		int year = getFecha().get(Calendar.YEAR);
		String fechaFormateada = day + month + year;
		return fechaFormateada;
	}

	@Override
	public String getNombreArchivo(Plantilla plantilla) {

		return plantilla.getAsigantura() + "-" + getFechaFormateada();
	}

	@Override
	public XSSFSheet getHoja(XSSFWorkbook workbook) {

		return workbook.createSheet(getFechaFormateada());
	}

	public ExcelImpl() {
	}
	
	

}
