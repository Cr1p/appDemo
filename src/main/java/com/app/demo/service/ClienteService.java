package com.app.demo.service;

import com.app.demo.dto.request.ClienteRequest;
import com.app.demo.dto.response.ClienteResponse;

public interface ClienteService {
	
	public ClienteResponse obtenerCliente(ClienteRequest request)throws Exception;
	public ClienteResponse insertarCliente(ClienteRequest request)throws Exception;
	public ClienteResponse actualizarCliente(ClienteRequest request)throws Exception;
	public ClienteResponse eliminarCliente(ClienteRequest request)throws Exception;
	
	public ClienteResponse calcularPromDes(ClienteRequest request)throws Exception;
	public ClienteResponse calcularPosibleMuerte(ClienteRequest request)throws Exception;
}
