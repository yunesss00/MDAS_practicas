package es.uco.mdas.negocio.socio;

import java.util.Date;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;


public class ObjetoAbono implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idAbono;
	private Long idSocio;
	private LocalDate fechaExpedicionAbono;
	private String deporteAbono;
	private String tipoAbono;
	private int localidad = 0;

	
	public ObjetoAbono() {}
	
	public ObjetoAbono(String deporteAbono, String tipoAbono, Long idSocio) {
		this.deporteAbono = deporteAbono;
		this.tipoAbono = tipoAbono;
		this.localidad = 0;
		this.idAbono = null;
		this.idSocio = idSocio;
		this.fechaExpedicionAbono = null;

	
	}
	
	public Long getIdSocio(){
		return idSocio;
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
	
	
	public void setIdSocio(long idSocio) {
		this.idSocio = idSocio;
	}
	
	public void setIdAbono(long idAbono) {
		this.idAbono = idAbono;
	}
	
	public void setDeporteAbono(String deporteAbono) {
		this.deporteAbono = deporteAbono;
	}
	
	public void setLocalidad() {
		int idMaximo = 9999;
		int idMinimo = 0;
        this.localidad = (int) Math.floor(Math.random()*(idMaximo-idMinimo+1)+idMinimo);
	}
	
	public void setTipoAbono(String tipoAbono) {
		this.tipoAbono = tipoAbono;
	}
	
	public void setFechaExpedicionAbono() {
		String mesDia= "-09-16";
		LocalDate fechaExpedicionAbono = null;
		Date date = new Date();
		int anyoExpedicion;
		String aux;
		
        ZoneId zonaHoraria = ZoneId.systemDefault();
        LocalDate fechaActual = date.toInstant().atZone(zonaHoraria).toLocalDate();
        anyoExpedicion = fechaActual.getYear() + 1;
        aux = Integer.toString(anyoExpedicion) + mesDia;
        
        fechaExpedicionAbono = LocalDate.parse(aux);
		this.fechaExpedicionAbono = fechaExpedicionAbono;	
	}

	public void leerLocalidadAbono(String aux){
		int localidad = Integer.parseInt(aux);
		this.localidad = localidad;
	}
	/**
	 * Simplemente se usa para leer del fichero y crear la clase abono
	 * @param aux
	 */
	public void leerFechaExpedicionAbono(String aux){
		LocalDate fechaExpedicion;
		fechaExpedicion = LocalDate.parse(aux);
		this.fechaExpedicionAbono = fechaExpedicion;
	}
	
	public void calcularIdAleatoria() {
		int idMaximo = 9999;
		int idMinimo = 0;
        this.idAbono = (long) Math.floor(Math.random()*(idMaximo-idMinimo+1)+idMinimo);
    }

	public String infoAbono() {
		return "IDSocio : " + idSocio +"\nIDAbono : " + idAbono +" \nDeporte : " + deporteAbono +
			"\nTipo abono : " + tipoAbono + "\nFechaExpedicion : " + fechaExpedicionAbono + "\nLocalidad : " + localidad;
		
	}
}
