package es.uco.mdas.negocio.socio;

import java.io.Serializable;
import java.util.Date;

public class ObjetoSocio implements Serializable {

	private Long idSocio;
	private String nombreSocio;
	private String apellidosSocio;
	private Date fechaNacimientoSocio;
	private int antiguedadSocio;
	private TipoCarnet tipoCarnet;
	
	public ObjetoSocio(Long idSocio, String nombreSocio, String apellidosSocio,
			Date fechaNacimientoSocio, int antiguedadSocio, TipoCarnet tipoCarnet) {
		this.nombreSocio = nombreSocio;
		this.apellidosSocio = apellidosSocio;
		this.fechaNacimientoSocio = fechaNacimientoSocio;
		this.antiguedadSocio = antiguedadSocio;
		this.tipoCarnet = tipoCarnet;
	}

	public ObjetoSocio(String nombreSocio, String apellidosSocio,
			Date fechaNacimientoSocio) {
		this.nombreSocio = nombreSocio;
		this.apellidosSocio = apellidosSocio;
		this.fechaNacimientoSocio = fechaNacimientoSocio;
	}
	public Long getIdSocio() {
		return idSocio;
	}
	
	public String getNombreSocio() {
		return nombreSocio;
	}
	
	public String getApellidosSocio() {
		return apellidosSocio;
	}
	
	public Date getFechaNacimientoSocio() {
		return fechaNacimientoSocio;
	}
	
	public int getAntiguedadSocio() {
		return antiguedadSocio;
	}
	
	public TipoCarnet getTipoCarnet() {
		return tipoCarnet;
	}
	
	public void setIdSocio(Long idSocio) {
		this.idSocio = idSocio;
	}
	
	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}
	
	public void setApellidosSocio(String apellidosSocio) {
		this.apellidosSocio = apellidosSocio;
	}
	
	public void setFechaNacimiento(Date fechaNacimientoSocio) {
		this.fechaNacimientoSocio = fechaNacimientoSocio;
	}
	
	public void setAntiguedadSocio(int antiguedadSocio) {
		this.antiguedadSocio = antiguedadSocio;
	}
	
	public void setTipoCarnet(TipoCarnet tipoCarnet) {
		this.tipoCarnet = tipoCarnet;
	}
}

