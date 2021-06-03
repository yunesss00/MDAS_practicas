package es.uco.mdas.datos;

import java.util.Date;

public class Abono {
	
	private Long idAbono;
	private Date fechaExpedicionAbono;
	private String deporteAbono;
	private String tipoAbono;
	
	public Abono(Long idAbono, Date fechaExpedicionAbono, String deporteAbono, String tipoAbono) {
		this.idAbono = idAbono;
		this.fechaExpedicionAbono = fechaExpedicionAbono;
		this.deporteAbono = deporteAbono;
		this.tipoAbono = tipoAbono;
	}
	
	public Long getIdAbono() {
		return idAbono;
	}
	
	public Date getFechaExpedicionAbono() {
		return fechaExpedicionAbono;
	}
	
	public String getDeporteAbono() {
		return deporteAbono;
	}
	
	public String getTipoAbono() {
		return tipoAbono;
	}
	
	public void setIdAbono(Long idAbono) {
		this.idAbono = idAbono;
	}
	
	public void setFechaExpedicionAbono(Date fechaExpedicionAbono) {
		this.fechaExpedicionAbono = fechaExpedicionAbono;
	}
	
	public void setDeporteAbono(String deporteAbono) {
		this.deporteAbono = deporteAbono;
	}
}
