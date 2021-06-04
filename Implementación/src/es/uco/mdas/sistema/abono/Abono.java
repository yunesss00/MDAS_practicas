package es.uco.mdas.sistema.abono;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;


public class Abono {
	
	private Long idAbono = (long) 0;
	private LocalDate fechaExpedicionAbono;
	private String deporteAbono;
	private String tipoAbono;
	private int localidad = 0;

	
	public Abono() {}
	
	public Abono(String deporteAbono, String tipoAbono) {
		this.deporteAbono = deporteAbono;
		this.tipoAbono = tipoAbono;
		this.localidad = localidad++;
		
		//Calcular la fecha de expedicion para la siguiente temporada
		String mesDia= "-09-16";
		LocalDate fechaExpedicionAbono = null;
		Date date = new Date();
		int añoExpedicion;
		String aux;
		
        ZoneId zonaHoraria = ZoneId.systemDefault();
        LocalDate fechaActual = date.toInstant().atZone(zonaHoraria).toLocalDate();
        añoExpedicion = fechaActual.getYear() + 1;
        aux = Integer.toString(añoExpedicion) + mesDia;
        
        fechaExpedicionAbono = LocalDate.parse(aux);
		this.fechaExpedicionAbono = fechaExpedicionAbono;
		
		//Calcular la id del abono
		int idAbonoMax = 9999;
		Long idAleatorio = (long) Math.random()*idAbonoMax;
		this.idAbono = idAleatorio;	
	
	}
	
	
	public Long getIdAbono() {
		return idAbono;
	}
	
	public LocalDate getFechaExpedicionAbono() {
		return fechaExpedicionAbono;
	}
	
	public String getDeporteAbono() {
		return deporteAbono;
	}
	
	public String getTipoAbono() {
		return tipoAbono;
	}
	
	public int getLocalidad() {
		return localidad;
	}
	
	
	public void setIdAbono(Long idAbono) {
		this.idAbono = idAbono;
	}
	
	public void setFechaExpedicionAbono(LocalDate fechaExpedicionRenovada) {
		this.fechaExpedicionAbono = fechaExpedicionRenovada;
	}
	
	public void setDeporteAbono(String deporteAbono) {
		this.deporteAbono = deporteAbono;
	}
	
	public void setLocalidad(int localidad) {
		this.localidad = localidad;
	}
}
