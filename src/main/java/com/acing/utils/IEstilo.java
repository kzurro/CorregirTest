package com.acing.utils;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface IEstilo {
	
	public XSSFCellStyle getEstilo(XSSFWorkbook workbook);
	public void setFuente( XSSFWorkbook workbook, XSSFCellStyle estilo, int tamanio, String tipoLetra, boolean negrita, boolean colorRojo);
	public void setBordesGruesos(XSSFWorkbook workbook , XSSFCellStyle style);
	public void setColorBordes(XSSFCellStyle style);
	public void setBordesGruesos(XSSFCellStyle style,  boolean top, boolean bottom, boolean left, boolean right);
	public void setBordesFinos(XSSFCellStyle style,  boolean top, boolean bottom, boolean left, boolean right);
	public void setColorBordesFinos(XSSFCellStyle style,  boolean top, boolean bottom, boolean left, boolean right);
	public void setColorBordes(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right);
	public void setColorBordesGruesos(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right);
	public void setColorBordesGruesos(XSSFCellStyle style, TipoAlineadoHorizontal tipoAlineado, boolean top, boolean bottom, boolean left, boolean right);
	public void setColorBordesGruesos(XSSFWorkbook workbook, XSSFCellStyle style, int tamanio, String tipoLetra, boolean negrita,TipoAlineadoHorizontal tipoAlineado, boolean top, boolean bottom, boolean left, boolean right);
	public void setColorBordesGruesos(XSSFWorkbook workbook, XSSFCellStyle style, int tamanio, String tipoLetra, boolean negrita,TipoAlineadoVertical tipoAlineadoVertical, TipoAlineadoHorizontal tipoAlineado, boolean top, boolean bottom, boolean left, boolean right);
	
	

}
