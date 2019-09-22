/**
 * 
 */
package com.app.demo.helpers;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author daniel - 28 ago. 2017
 *
 */
public class ResponseHelper
{
	public static String obtenerCodigoErrorPorFecha( String nombreAPI )
	{
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String codigoError = formatter.format(new Date());

		return String.format( "%s-%s", nombreAPI, codigoError );
	}
}
