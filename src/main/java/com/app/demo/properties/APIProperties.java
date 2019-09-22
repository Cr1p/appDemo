package com.app.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class APIProperties
{
	@Value("${api.nombre}")
	private String nombre;

	@Value("${api.descripcion}")
	private String descripcion;

	@Value("${api.version}")
	private String version;

	@Value("${api.autor.nombre}")
	private String nombreAutor;

	@Value("${api.autor.correo}")
	private String correoAutor;

	@Value("${api.autor.web}")
	private String webAutor;

	public String getNombre()
	{
		return nombre;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public String getVersion()
	{
		return version;
	}

	public String getNombreAutor()
	{
		return nombreAutor;
	}

	public String getCorreoAutor()
	{
		return correoAutor;
	}

	public String getWebAutor()
	{
		return webAutor;
	}
}
