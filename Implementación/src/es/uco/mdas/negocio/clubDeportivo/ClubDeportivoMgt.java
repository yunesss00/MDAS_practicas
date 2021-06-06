package es.uco.mdas.negocio.clubDeportivo;

public interface ClubDeportivoMgt {
	
	/**
	 * Funcion que comprueba la existencia de una Localidad
	 * @param idLocalidad
	 * @return Retorna True si la Localidad existe y False si la Localidad no existe
	 */

	public boolean comprobarExistenciaLocalidad(Long idLocalidad);
	
	/**
	 * Funcion que muestra los datos de una Localidad
	 * @param idLocalidad
	 * @return Retorna la Localidad que contenga el ID que se le pasa
	 */
	
	public ObjetoLocalidad mostrarDatosLocalidad(Long idLocalidad);
	
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
	
	/**
	 * Funcion que actualiza el estado de la Localidad para la cual se ha comprado la entrada
	 * @param idLocalidad
	 */
	
	public void actualizarLocalidad(Long idLocalidad);
	
	/**
	 * Funcion que notifica del Pago de la entrada
	 * @param idLocalidad
	 * @return retorna la informacion de la localidad para la que se ha comprado la entrada
	 */
	
	public String notificarPago(Long idLocalidad);
	
	/**
	 * Funcion que añade los datos de una nueva entrada al sistema
	 * @param entrada
	 * @return true si ha guardado correctamente la entrada false si no ha guardado la entrada
	 */
	
	public boolean setDatosEntrada(ObjetoEntrada entrada);
	
	/**
	 * Funcion que indica si existe una entrada vendida
	 * @param idlocalidad
	 * @return Retorna true si ya existe una entrada para esa localidad y false si se encuentra disponible
	 */
	
	public boolean existeEntrada(Long idLocalidad);
	
	

}
