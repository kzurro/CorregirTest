package com.acing.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;



/**
 * @author kzurro
 *
 *Clase para generar Celdas con estilo o sin el 
 *se ha utilizado la libreria de StingUtilis para quitar los acentos a los strings descomentar linea value = stringUtils.stripAccents(value);
 *<a href="https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html">Ver</a>
 */
public class CeldaImpl implements ICelda{
	
	private StringUtils stringUtils;

	@Override
	public XSSFCell getCelda(XSSFRow row, int celda, String value) {
		XSSFCell cell = (XSSFCell) row.createCell((short) celda);
		//value = stringUtils.stripAccents(value);
		cell.setCellValue(value);
		return cell;
	}

	@Override
	public XSSFCell getCeldaConEstilo(XSSFRow row, int celda, String value, XSSFCellStyle style) {
		XSSFCell cell = getCelda(row, celda, value);
		cell.setCellStyle(style);
		return cell;
	}

	public CeldaImpl() {
		this.stringUtils = new StringUtils();
		
	}
	
	
}
