package es.uco.mdas.negocio.clubDeportivo;

import java.sql.Time;
import java.util.Date;

public class ObjetoEntrada {


	private long idEntrada;
	private ObjetoLocalidad localidad;
	private Date fechaPartido;  
	private Time horaPartido;
	private String comprador;
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
	
	public ObjetoEntrada(long idEntrada, ObjetoLocalidad localidad, Date fechaPartido, Time horaPartido, String comprador, float precio ) {
		this.idEntrada = idEntrada;
		this.localidad = localidad;
		this.fechaPartido = fechaPartido;  
		this.horaPartido = horaPartido;
		this.comprador = comprador;
		this.precio = precio;
	
		
	}
	
	public long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public ObjetoLocalidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(ObjetoLocalidad localidad) {
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

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String equipo) {
		this.comprador = equipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String infoEntrada() {
		String infoEntrada = "IDEntrada : " + idEntrada + " Localidad : " + localidad + " FechaPartido : " 
				+ fechaPartido + " HoraPartido : " + horaPartido + " Comprador : " + comprador + " Precio : " + precio;
		return infoEntrada;
	}
}
