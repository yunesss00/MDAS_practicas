package es.uco.mdas.datos;

import java.util.Date;

public class Abono {
	
	private Long idAbono;
	private Date fechaExpedicion;
	
	public Abono(Long idAbono, Date fechaExpedicion) {
		this.idAbono = idAbono;
		this.fechaExpedicion = fechaExpedicion;
	}
	
	public Long getIdAbono() {
		return idAbono;
	}
	
	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}
	
	
	public void setIdAbono(Long idAbono) {
		this.idAbono = idAbono;
	}
	
	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
}
