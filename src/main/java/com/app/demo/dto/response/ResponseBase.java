package com.app.demo.dto.response;

public class ResponseBase
{
	private int estado;
	private String mensaje;
	private String codigoError;

	public int getEstado()
	{
		return estado;
	}

	public void setEstado(int estado)
	{
		this.estado = estado;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	public String getCodigoError()
	{
		return codigoError;
	}

	public void setCodigoError(String codigoError)
	{
		this.codigoError = codigoError;
	}
}