/**
 * 
 */
package com.app.demo.dto.request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.demo.entidad.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Andy
 *
 */
public class ClienteRequest {
	
	private String nombreCliente;
	private Integer idCliente;
	private Cliente cliente;
	private String clienteJSON;

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(cliente);
			String a = json.replaceAll(Pattern.quote("\\"),Matcher.quoteReplacement(""));
			String b = a.replaceAll(Pattern.quote("\"["),Matcher.quoteReplacement("["));
			String c = b.replaceAll(Pattern.quote("]\""),Matcher.quoteReplacement("]"));
			setClienteJSON(c);
		} catch (Exception e) {
		}
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getClienteJSON() {
		return clienteJSON;
	}

	public void setClienteJSON(String clienteJSON) {
		this.clienteJSON = clienteJSON;
	}
	

}
