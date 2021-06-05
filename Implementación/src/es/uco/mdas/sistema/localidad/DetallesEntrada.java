package es.uco.mdas.sistema.localidad;

import java.sql.Time;
import java.util.Date;

public class DetallesEntrada {


	private long idEntrada;
	private DetallesLocalidad localidad;
	private Date fechaPartido;  
	private Time horaPartido;
	private String equipo;
	private float precio;
	
	/**
	 * Constructor estandar de una entrada
	 * 
	 * @param idEntrada 
	 * @param localidad 
	 * @param fechaPartido 
	 * @param horaPartido
	 * @param equipo
	 * @param precio
	 */
	
	public DetallesEntrada(long idEntrada, DetallesLocalidad localidad, Date fechaPartido, Time horaPartido, String equipo, float precio ) {
		this.idEntrada = idEntrada;
		this.localidad = localidad;
		this.fechaPartido = fechaPartido;  
		this.horaPartido = horaPartido;
		this.equipo = equipo;
		this.precio = precio;
	
		
	}
	
	public long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public DetallesLocalidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(DetallesLocalidad localidad) {
		this.localidad = localidad;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public Time getHoraPartido() {
		return horaPartido;
	}

	public void setHoraPartido(Time horaPartido) {
		this.horaPartido = horaPartido;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String infoLocalidad() {
		String infoLocalidad = "IDEntrada : " + idEntrada + " Localidad : " + localidad + " FechaPartido : " + fechaPartido + " HoraPartido : " + horaPartido + " Equipo : " + equipo + " Precio : " + precio;
		return infoLocalidad;
	}
}
