package es.uco.mdas.sistema.localidad;

public interface ComprobarDisponibilidadLocalidad {
	
	/**
	 * Funcion que comprueba si una Localidad se encuentra Reservada
	 * @param idLocalidad
	 * @return Retorna True si la Localidad se encuentra reserva y false si la Localidad se encuentra Disponible
	 */
	public boolean comprobarReservaLocalidad(Long idLocalidad);
	
	
	/**
	 * Funcion que comprueba el estado de la Localidad
	 * @param idLocalidad
	 * @return Retorna el estado de la Localidad que se le pasa
	 */
	public String notificarDisponibilidadLocalidad(Long idLocalidad);
	
}
