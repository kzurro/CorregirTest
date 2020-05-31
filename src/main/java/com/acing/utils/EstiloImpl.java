package com.acing.utils;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EstiloImpl implements IEstilo {

	IAlinear alinear;

	@Override
	public XSSFCellStyle getEstilo(XSSFWorkbook workbook) {
		return workbook.createCellStyle();
	}

	@Override
	public void setFuente(XSSFWorkbook workbook, XSSFCellStyle estilo, int tamanio, String tipoLetra, boolean negrita, boolean colorRojo) {
		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) tamanio);
		font.setFontName(tipoLetra);
		font.setBold(negrita);
		if(colorRojo) font.setColor(IndexedColors.RED.getIndex());
		estilo.setFont(font);
	}

	@Override
	public void setBordesGruesos(XSSFWorkbook workbook, XSSFCellStyle style) {
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setBorderTop(BorderStyle.MEDIUM);

	}

	@Override
	public void setColorBordes(XSSFCellStyle style) {
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	}

	@Override
	public void setBordesGruesos(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right) {
		if (top)
			style.setBorderTop(BorderStyle.MEDIUM);
		if (bottom)
			style.setBorderBottom(BorderStyle.MEDIUM);
		if (left)
			style.setBorderLeft(BorderStyle.MEDIUM);
		if (right)
			style.setBorderRight(BorderStyle.MEDIUM);

	}

	@Override
	public void setColorBordes(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right) {
		if (top)
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		if (bottom)
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		if (left)
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		if (right)
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());

	}

	@Override
	public void setColorBordesGruesos(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right) {
		if (top) {
			style.setTopBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderTop(BorderStyle.MEDIUM);
		}
		if (bottom) {
			style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderBottom(BorderStyle.MEDIUM);
		}
		if (left) {
			style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderLeft(BorderStyle.MEDIUM);
		}
		if (right) {
			style.setRightBorderColor(IndexedColors.BLACK.getIndex());
			style.setBorderRight(BorderStyle.MEDIUM);
		}
	}

	@Override
	public void setColorBordesGruesos(XSSFCellStyle style, TipoAlineadoHorizontal tipoAlineado, boolean top,
			boolean bottom, boolean left, boolean right) {
		setBordesGruesos(style, top, bottom, left, right);
		alinear.setAlinearHorizontal(style, tipoAlineado);
	}

	@Override
	public void setColorBordesGruesos(XSSFWorkbook workbook, XSSFCellStyle style, int tamanio, String tipoLetra,
			boolean negrita, TipoAlineadoHorizontal tipoAlineado, boolean top, boolean bottom, boolean left,
			boolean right) {
		setFuente(workbook, style, tamanio, tipoLetra, negrita, false);
		setColorBordesGruesos(style, tipoAlineado, top, bottom, left, right);
	}

	@Override
	public void setColorBordesGruesos(XSSFWorkbook workbook, XSSFCellStyle style, int tamanio, String tipoLetra,
			boolean negrita, TipoAlineadoVertical tipoAlineadoVertical, TipoAlineadoHorizontal tipoAlineado,
			boolean top, boolean bottom, boolean left, boolean right) {
		setColorBordesGruesos(workbook, style, tamanio, tipoLetra, negrita, tipoAlineado, top, bottom, left, right);
		alinear.setAlinearVertical(style, tipoAlineadoVertical);

	}

	@Override
	public void setBordesFinos(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right) {
		if (top)
			style.setBorderTop(BorderStyle.THIN);
		if (bottom)
			style.setBorderBottom(BorderStyle.THIN);
		if (left)
			style.setBorderLeft(BorderStyle.THIN);
		if (right)
			style.setBorderRight(BorderStyle.THIN);

	}

	@Override
	public void setColorBordesFinos(XSSFCellStyle style, boolean top, boolean bottom, boolean left, boolean right) {
		setColorBordes(style, top, bottom, left, right);
		setBordesFinos(style, top, bottom, left, right);

	}

	public EstiloImpl() {
		this.alinear = new AlinearImpl();

	}

}
