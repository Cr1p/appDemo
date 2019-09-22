/**
 * 
 */
package com.app.demo.dto.response;

import java.util.List;

import com.app.demo.entidad.Cliente;
import com.app.demo.entidad.Confirmacion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author Andy
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class ClienteResponse extends ResponseBase {

	
	
	@Override
	public String toString() {
		return "ClienteResponse [\n " + (cliente != null ? "cliente=" + cliente + ", \n " : "")
				+ (clienteList != null ? "clienteList=" + clienteList + ", \n " : "")
				+ (confirmacion != null ? "confirmacion=" + confirmacion : "") + "\n]";
	}

	private Cliente cliente;
	private List<Cliente> clienteList;
	private Confirmacion confirmacion;
	
	private Double promedio;
	private Double desviacionEstandar;
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public Confirmacion getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}

	public Double getPromedio() {
		return promedio;
	}

	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

	public Double getDesviacionEstandar() {
		return desviacionEstandar;
	}

	public void setDesviacionEstandar(Double desviacionEstandar) {
		this.desviacionEstandar = desviacionEstandar;
	}

	
}
