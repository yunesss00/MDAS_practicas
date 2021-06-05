package es.uco.mdas.negocio.clubDeportivo;


public class ObjetoLocalidad {

	private long idLocalidad;
	private long idAbono;
	private String zona;
	private String sector;
	private int fila;
	private int asiento;
	private String estado;
	
	
	/**
	 * Constructor completo de una localidad
	 * 
	 * @param idLocalidad 
	 * @param 
	 * @param 
	 * @param
	 * @param 
	 * @param 
	 */
	public ObjetoLocalidad(long idLocalidad, long idAbono, int fila, String sector, String zona, String estado) {
		this.idLocalidad = idLocalidad;
		this.idAbono = idAbono;
		this.zona = zona;
		this.sector = sector;
		this.fila = fila;
		this.estado = estado;
		
	}
	
	public long getIdLocalidad() {
		return idLocalidad;
	}


	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}


	public long getIdAbono() {
		return idAbono;
	}


	public void setIdAbono(long idAbono) {
		this.idAbono = idAbono;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}


	public int getFila() {
		return fila;
	}


	public void setFila(int fila) {
		this.fila = fila;
	}


	public int getAsiento() {
		return asiento;
	}


	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String infoLocalidad() {
		String infoLocalidad = "IDLocalidad : " + idLocalidad + " IDAbono : " + idAbono + " Zona : " 
				+ zona + " Sector : " + sector + " Fila : " + fila + " Asiento : " + asiento + " Estado : " + estado;
		return infoLocalidad;
	}
}
