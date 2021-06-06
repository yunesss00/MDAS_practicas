package es.uco.mdas.negocio.clubDeportivo;

public interface ClubDeportivoMgt {
	
	public boolean comprobarExistenciaLocalidad(Long idLocalidad);
	
	public ObjetoLocalidad mostrarDatosLocalidad(Long idLocalidad);
	
	public boolean comprobarReservaLocalidad(Long idLocalidad);
	
	public String notificarDisponibilidadLocalidad(Long idLocalidad);
	
	public void actualizarLocalidad(Long idLocalidad);
	
	public String notificarPago(Long idLocalidad);
	
	public boolean setDatosEntrada(ObjetoEntrada entrada);

}
