package com.app.demo.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {
	public static final int	PDF						= 2;
	public static final int	EXCEL						= 1;
	public static String getCodigoErrorByDate()
	{
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String codigoError = formatter.format(new Date());

		return codigoError;
	}

}
