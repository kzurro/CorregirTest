package com.acing.utils;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public interface IAlinear {
	public void setAlinearHorizontal(XSSFCellStyle style, TipoAlineadoHorizontal tipoAlineado);
	public void setAlinearVertical(XSSFCellStyle style, TipoAlineadoVertical tipoAlineado);
	public void setAlinearHorizontalVertical(XSSFCellStyle style, TipoAlineadoHorizontal tipoAlineadoHorizontal, TipoAlineadoVertical tipoAlineadoVertical);

}
