package com.acing.utils;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 * @author kzurro
 * 
 *Clase para alinear el texto en la celdas tanto horizontalmenete como verticalmente
 */

public class AlinearImpl implements IAlinear {

	@Override
	public void setAlinearHorizontal(XSSFCellStyle style, TipoAlineadoHorizontal tipoAlineado) {
		switch (tipoAlineado) {
		case CENTRO:
			style.setAlignment(HorizontalAlignment.CENTER);

			break;
		case IZQUIERDA:
			style.setAlignment(HorizontalAlignment.LEFT);

			break;
		case DERECHA:
			style.setAlignment(HorizontalAlignment.RIGHT);

			break;
		default:
			break;
		}
	}

	@Override
	public void setAlinearVertical(XSSFCellStyle style, TipoAlineadoVertical tipoAlineado) {
		switch (tipoAlineado) {
		case CENTER:
			style.setVerticalAlignment(VerticalAlignment.CENTER);

			break;
		case TOP:
			style.setVerticalAlignment(VerticalAlignment.TOP);

			break;
		case BOTTOM:
			style.setVerticalAlignment(VerticalAlignment.BOTTOM);

			break;
		default:
			break;
		}

	}

	@Override
	public void setAlinearHorizontalVertical(XSSFCellStyle style, TipoAlineadoHorizontal tipoAlineadoHorizontal,
			TipoAlineadoVertical tipoAlineadoVertical) {
		setAlinearHorizontal(style, tipoAlineadoHorizontal);
		setAlinearVertical(style, tipoAlineadoVertical);
		
	}



}
