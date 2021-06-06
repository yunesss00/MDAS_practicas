package es.uco.mdas.negocio.clubDeportivo;

import java.io.Serializable;
import java.util.Date;

public class ObjetoEntrada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idEntrada;
	private Long idLocalidad;
	private Date fechaPartido;  
	private String horaPartido;
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
	
	public ObjetoEntrada(Long idEntrada, Long idLocalidad, Date fechaPartido, String horaPartido, String comprador, float precio ) {
		this.idEntrada = idEntrada;
		this.idLocalidad = idLocalidad;
		this.fechaPartido = fechaPartido;  
		this.horaPartido = horaPartido;
		this.comprador = comprador;
		this.precio = precio;
	
		
	}
	
	/**
	 * Constructor vacío de una entrada
	 */
	
	public ObjetoEntrada() {}
	
	public Long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(long idlocalidad) {
		this.idLocalidad = idlocalidad;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public String getHoraPartido() {
		return horaPartido;
	}

	public void setHoraPartido(String horaPartido) {
		this.horaPartido = horaPartido;
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	public void calcularIdAleatoria() {
		int idMaximo = 9999;
		int idMinimo = 0;
		this.idEntrada = (long) Math.floor(Math.random()*(idMaximo-idMinimo+1)+idMinimo);
	}
	
	/**
	 * Función que agrupa los atributos de una entrada en un String 
	 * @return infoEntrada 
	 */
	
	public String infoEntrada() {
		String infoEntrada = "IDEntrada : " + idEntrada + " Localidad : " + idLocalidad + " FechaPartido : " 
				+ fechaPartido + " HoraPartido : " + horaPartido + " Comprador : " + comprador + " Precio : " + precio;
		return infoEntrada;
	}
}
