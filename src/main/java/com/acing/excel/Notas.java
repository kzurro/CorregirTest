package com.acing.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.acing.examen.CorregibleImpl;
import com.acing.examen.Plantilla;
import com.acing.utils.AlinearImpl;
import com.acing.utils.CapitalizarTexto;
import com.acing.utils.CeldaImpl;
import com.acing.utils.EstiloImpl;
import com.acing.utils.ExcelImpl;
import com.acing.utils.IAlinear;
import com.acing.utils.ICelda;
import com.acing.utils.IEstilo;
import com.acing.utils.IExcel;



/**
 * @author kzurro
 *
 *Clase que tiene el método que genera el excel pasandole por argumentos los datos obtenidos del serializador
 */
public class Notas {

	ICelda celda;

	IEstilo estilo;

	IExcel excel;

	IAlinear alinear;

	CapitalizarTexto capitalizar;

	final String tipoLetra = "Arial";

	final int tamanio = 10;

	public void setHojaCalificaciones(Plantilla plantilla, List<CorregibleImpl> resultados) throws IOException {

		XSSFWorkbook workbook = excel.getExcel();
		XSSFSheet spreadsheet = excel.getHoja(workbook);
		
		spreadsheet.setColumnWidth(1, 8000);
		spreadsheet.setColumnWidth(2, 2000);
		spreadsheet.setColumnWidth(3, 2000);
		spreadsheet.setColumnWidth(4, 3000);
		spreadsheet.setColumnWidth(5, 2000);
		XSSFRow row = spreadsheet.createRow(0);
		XSSFCell cell = celda.getCelda(row, 0, "Número");
		XSSFCellStyle style = estilo.getEstilo(workbook);
		estilo.setFuente(workbook, style, tamanio, tipoLetra, true, false);
		estilo.setColorBordesGruesos(style, true, true, true, true);
		cell.setCellStyle(style);
		cell = celda.getCeldaConEstilo(row, 1, "Alumno", style);
		cell = celda.getCeldaConEstilo(row, 2, "Aciertos", style);
		cell = celda.getCeldaConEstilo(row, 3, "Errores", style);
		cell = celda.getCeldaConEstilo(row, 4, "No Contestadas", style);
		cell = celda.getCeldaConEstilo(row, 5, "Nota", style);

		XSSFCellStyle styleAlumnos = estilo.getEstilo(workbook);
		estilo.setFuente(workbook, style, tamanio, tipoLetra, false, false);
		estilo.setColorBordesFinos(styleAlumnos, true, true, true, true);
		
		XSSFCellStyle styleSuspenso = estilo.getEstilo(workbook);
		estilo.setFuente(workbook, styleSuspenso, tamanio, tipoLetra, false, true);
		estilo.setColorBordesFinos(styleSuspenso, true, true, true, true);
		XSSFCellStyle styleNotas = estilo.getEstilo(workbook);
		int alumnos = resultados.size();

		for (int i = 0; i < alumnos; i++) {
			if(resultados.get(i).getNota() < 5) styleNotas = styleSuspenso;
			else styleNotas = styleAlumnos;
			row = spreadsheet.createRow(i + 1);
			cell = celda.getCeldaConEstilo(row, 0, String.valueOf(i + 1), styleNotas);
			cell = celda.getCeldaConEstilo(row, 1, resultados.get(i).getNombre(), styleNotas);
			cell = celda.getCeldaConEstilo(row, 2, String.valueOf(resultados.get(i).getAciertos()), styleNotas);
			cell = celda.getCeldaConEstilo(row, 3, String.valueOf(resultados.get(i).getErrores()), styleNotas);
			cell = celda.getCeldaConEstilo(row, 4, String.valueOf(resultados.get(i).getNoContestadas()), styleNotas);
			cell = celda.getCeldaConEstilo(row, 5, String.valueOf(resultados.get(i).getNota()), styleNotas);
		}

		FileOutputStream out = excel.getCierreExcel(workbook, plantilla);
	}

	public ICelda getCelda() {
		return celda;
	}

	public IEstilo getEstilo() {
		return estilo;
	}

	public IExcel getExcel() {
		return excel;
	}

	public IAlinear getAlinear() {
		return alinear;
	}

	public CapitalizarTexto getCapitalizar() {
		return capitalizar;
	}

	public String getTipoLetra() {
		return tipoLetra;
	}

	public int getTamanio() {
		return tamanio;
	}

	private void setCelda(ICelda celda) {
		this.celda = celda;
	}

	private void setEstilo(IEstilo estilo) {
		this.estilo = estilo;
	}

	private void setExcel(IExcel excel) {
		this.excel = excel;
	}

	private void setAlinear(IAlinear alinear) {
		this.alinear = alinear;
	}

	private void setCapitalizar(CapitalizarTexto capitalizar) {
		this.capitalizar = capitalizar;
	}

	public Notas() {
		setCelda(new CeldaImpl());
		setEstilo(new EstiloImpl());
		setExcel(new ExcelImpl());
		setAlinear(new AlinearImpl());
		setCapitalizar(new CapitalizarTexto());

	}

}
