package com.acing.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.acing.examen.Plantilla;

public interface IExcel extends IFecha{
	
	public XSSFWorkbook getExcel();
	
	public XSSFSheet getHoja(XSSFWorkbook workbook);
	
	public FileOutputStream getCierreExcel(XSSFWorkbook workbook, Plantilla plantilla) throws FileNotFoundException, IOException;

	public String getNombreArchivo(Plantilla propietario);
}
