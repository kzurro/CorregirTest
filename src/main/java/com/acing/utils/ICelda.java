package com.acing.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;

public interface ICelda {
	public XSSFCell getCelda(XSSFRow row, int celda, String value);
	public XSSFCell getCeldaConEstilo(XSSFRow row, int celda, String value, XSSFCellStyle style);
	
}
