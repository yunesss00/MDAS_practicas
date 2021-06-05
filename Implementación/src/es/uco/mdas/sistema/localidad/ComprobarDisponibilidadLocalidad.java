package es.uco.mdas.sistema.localidad;

public interface ComprobarDisponibilidadLocalidad {
	
	public boolean comprobarReservaLocalidad(Long idLocalidad);
	
	public String notificarDisponibilidadLocalidad(Long idLocalidad);
	
}
