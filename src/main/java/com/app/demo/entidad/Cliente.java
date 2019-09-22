/**
 * 
 */
package com.app.demo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Andy
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class Cliente {
	
	@Override
	public String toString() {
		return "Cliente [\n " + (idCliente != null ? "idCliente=" + idCliente + ", \n " : "")
				+ (nomCliente != null ? "nomCliente=" + nomCliente + ", \n " : "")
				+ (apPaternoCliente != null ? "apPaternoCliente=" + apPaternoCliente + ", \n " : "")
				+ (apMaternoCliente != null ? "apMaternoCliente=" + apMaternoCliente + ", \n " : "")
				+ (feNacimiento != null ? "feNacimiento=" + feNacimiento + ", \n " : "")
				+ (feMuerte != null ? "feMuerte=" + feMuerte + ", \n " : "")
				+ (feProbableMuerte != null ? "feProbableMuerte=" + feProbableMuerte : "") + "\n]";
	}
	private Integer idCliente;
	private String nomCliente;
	private String apPaternoCliente;
	private String apMaternoCliente;
	private String feNacimiento;
	private Integer edad;
	private String feMuerte;
	private String feProbableMuerte;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApPaternoCliente() {
		return apPaternoCliente;
	}
	public void setApPaternoCliente(String apPaternoCliente) {
		this.apPaternoCliente = apPaternoCliente;
	}
	public String getApMaternoCliente() {
		return apMaternoCliente;
	}
	public void setApMaternoCliente(String apMaternoCliente) {
		this.apMaternoCliente = apMaternoCliente;
	}
	public String getFeNacimiento() {
		return feNacimiento;
	}
	public void setFeNacimiento(String feNacimiento) {
		this.feNacimiento = feNacimiento;
	}
	public String getFeMuerte() {
		return feMuerte;
	}
	public void setFeMuerte(String feMuerte) {
		this.feMuerte = feMuerte;
	}
	public String getFeProbableMuerte() {
		return feProbableMuerte;
	}
	public void setFeProbableMuerte(String feProbableMuerte) {
		this.feProbableMuerte = feProbableMuerte;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
}
