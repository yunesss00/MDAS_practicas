package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoEntrada;

public interface VenderEntrada {
	
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
	
	public boolean existeEntrada(Long idlocalidad);
}
