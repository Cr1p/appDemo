/**
 * 
 */
package com.app.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dao.ClienteDAO;
import com.app.demo.dto.request.ClienteRequest;
import com.app.demo.dto.response.ClienteResponse;
import com.app.demo.entidad.Cliente;
import com.app.demo.service.ClienteService;

/**
 * @author Andy
 *
 */
@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;


	@Override
	public ClienteResponse obtenerCliente(ClienteRequest request) throws Exception {
		ClienteResponse response = clienteDAO.obtenerCliente(request);
		for(Cliente _clienteList: response.getClienteList()) {
			Cliente c = new Cliente();
			c.setFeNacimiento(_clienteList.getFeNacimiento());
			ClienteRequest _request = new ClienteRequest();
			_request.setCliente(c);
			//cambiar x el nuevo metodo del servicio de fn_ge_select_cliente_edades_muertos
			ClienteResponse response2 = clienteDAO.calcularPosibleMuerte(_request);
			
			_clienteList.setFeProbableMuerte(calcularPromedioEdad(response2.getClienteList()).toString());
		}
		return response;
	}

	@Override
	public ClienteResponse insertarCliente(ClienteRequest request) throws Exception {
		return clienteDAO.insertarCliente(request);
	}

	@Override
	public ClienteResponse actualizarCliente(ClienteRequest request) throws Exception {
		return clienteDAO.actualizarCliente(request);
	}

	@Override
	public ClienteResponse eliminarCliente(ClienteRequest request) throws Exception {
		return clienteDAO.eliminarCliente(request);
	}
	

	@Override
	public ClienteResponse calcularPromDes(ClienteRequest request) throws Exception {
		ClienteResponse response = clienteDAO.obtenerCliente(request);
		
		response.setPromedio(calcularPromedioEdad(response.getClienteList()));
		response.setDesviacionEstandar(desviacionEstandar(response.getClienteList()));
		return response;
		
	}

	@Override
	public ClienteResponse calcularPosibleMuerte(ClienteRequest request) throws Exception {
		ClienteResponse response = clienteDAO.obtenerCliente(request);
		for(Cliente _clienteList: response.getClienteList()) {
			Cliente c = new Cliente();
			c.setFeNacimiento(_clienteList.getFeNacimiento());
			ClienteRequest _request = new ClienteRequest();
			//cambiar x el nuevo metodo del servicio de fn_ge_select_cliente_edades_muertos
			ClienteResponse response2 = clienteDAO.calcularPosibleMuerte(_request);
			
			_clienteList.setFeProbableMuerte(calcularPromedioEdad(response2.getClienteList()).toString());
		}
		return response;
	}

	
	
	public Double calcularPromedioEdad(List<Cliente> clienteList) throws Exception{
		Double prom = 0.0;
		Double suma = 0.0;
		
		for(Cliente _clienteList:clienteList) {
			suma += Double.parseDouble(_clienteList.getEdad().toString());
		}
		prom = suma/clienteList.size();
		return prom;
	}
	
	public Double desviacionEstandar(List<Cliente> clienteList) throws Exception{
		Double media = 0.0;
		Double varianza = 0.0;
		Double desviacion = 0.0;
		
		media = calcularPromedioEdad(clienteList);
		
		/*Calculo de la varianza*/
		for(Cliente _clienteList:clienteList) {
			Double rango = 0.0;
			rango = Math.pow(_clienteList.getEdad() - media,2);
			varianza += rango;
		}
		varianza = varianza / clienteList.size();
		/*FIN Calculo de la varianza*/
		
		desviacion =  Math.sqrt(varianza);

		return desviacion;
	}

}
