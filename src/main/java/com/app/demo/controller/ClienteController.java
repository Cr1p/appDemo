/**
 * 
 */
package com.app.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.ResponseEstado;
import com.app.demo.dto.request.ClienteRequest;
import com.app.demo.dto.response.ClienteResponse;
import com.app.demo.helpers.ResponseHelper;
import com.app.demo.properties.APIProperties;
import com.app.demo.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author Andy
 *
 */
@RestController
//@CrossOrigin(origins = "*")
@RequestMapping(value = "/cliente")
//@Api(value = "Cliente")
public class ClienteController {
	private static final Logger LOG = Logger.getLogger(ClienteController.class);

	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private ClienteService clienteService;
	

	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
//	@ApiOperation(value = "Obtener Clientes", notes = "Obtiene los clientes", response = ClienteResponse.class)
	public ClienteResponse obtenerCliente(@RequestParam("idCliente") Integer idCliente)throws Exception{
		
		ClienteResponse response = new ClienteResponse();
		ClienteRequest request = new ClienteRequest();
		
		request.setIdCliente(idCliente);
		try {
			response = clienteService.obtenerCliente(request);
			response.setEstado(ResponseEstado.OK);
			if (response.getCliente() == null) {
				response.setMensaje("No se encontro el cliente");
			} else {
				response.setMensaje("Cliente encontrado correctamente");
			}
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al obtener el cliente";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
			System.out.println(codigoError);
			
		}
		return response;
	}
	
	@RequestMapping( method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Insertar Clientes", notes = "Insertar los clientes", response = ClienteResponse.class)
	public ClienteResponse insertarCliente(@RequestBody ClienteRequest request)throws Exception{
		
		ClienteResponse response = new ClienteResponse();
//		ClienteRequest request = new ClienteRequest();
		
		try {
			response = clienteService.insertarCliente(request);
			response.setEstado(response.getConfirmacion().getId());
			response.setMensaje(response.getConfirmacion().getMensaje());
			
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al insertar el cliente";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
			
		}
		return response;
	}
	
	@RequestMapping( method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar Clientes", notes = "Actualizar los clientes", response = ClienteResponse.class)
	public ClienteResponse actualizarCliente(@RequestBody ClienteRequest request)throws Exception{
		
		ClienteResponse response = new ClienteResponse();
//		ClienteRequest request = new ClienteRequest();
		
		try {
			response = clienteService.actualizarCliente(request);
			response.setEstado(response.getConfirmacion().getId());
			response.setMensaje(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al actualizar el cliente";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
			
		}
		return response;
	}
	
	@RequestMapping( method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar Clientes", notes = "Eliminar los clientes", response = ClienteResponse.class)
	public ClienteResponse eliminarCliente(@RequestParam("idCliente") Integer idCliente)throws Exception{
		
		ClienteResponse response = new ClienteResponse();
		ClienteRequest request = new ClienteRequest();
		
		request.setIdCliente(idCliente);
		try {
			response = clienteService.eliminarCliente(request);
			response.setEstado(ResponseEstado.OK);
			response.setEstado(response.getConfirmacion().getId());
			response.setMensaje(response.getConfirmacion().getMensaje());
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al eliminar el cliente";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
			
		}
		return response;
	}
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
//	@ApiOperation(value = "Obtener Clientes", notes = "Obtiene los clientes", response = ClienteResponse.class)
	public ClienteResponse calcularPromDes()throws Exception{
		
		ClienteResponse response = new ClienteResponse();
		ClienteRequest request = new ClienteRequest();
		
		try {
			response = clienteService.obtenerCliente(request);
			response.setEstado(ResponseEstado.OK);
			if (response.getClienteList().size()<=0) {
				response.setMensaje("No se encontro el cliente");
			} else {
				response.setMensaje("Se calculo correctamente");
			}
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al obtener el cliente";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
			System.out.println(codigoError);
			
		}
		return response;
	}
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
//	@ApiOperation(value = "Obtener Clientes", notes = "Obtiene los clientes", response = ClienteResponse.class)
	public ClienteResponse calcularPosibleMuerte()throws Exception{
		
		ClienteResponse response = new ClienteResponse();
		ClienteRequest request = new ClienteRequest();
		
		try {
			response = clienteService.obtenerCliente(request);
			response.setEstado(ResponseEstado.OK);
			if (response.getClienteList().size()<=0) {
				response.setMensaje("No se encontro el cliente");
			} else {
				response.setMensaje("Cliente encontrado correctamente");
			}
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al obtener el cliente";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
			System.out.println(codigoError);
			
		}
		return response;
	}
}
