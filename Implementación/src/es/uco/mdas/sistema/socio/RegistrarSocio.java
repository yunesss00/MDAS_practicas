package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;

public interface RegistrarSocio {

	/**
	 * Funcion que introduce los datos de un nuevo socio en el sistema
	 * @param socio
	 * @return True si añade al socio con exito o False si no lo añade
	 */
	
	public boolean setDatosSocio(ObjetoSocio socio);
	
	/**
	 * Funcion que establece el tipo del socio que se le pasa como parámetro
	 * @param tipoSocio
	 * @param socio
	 * @return Retorna el socio con el tipo establecido
	 */
	
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio);
	
	/**
	 * Funcion que notifica el alta de un socio
	 * @param idSocio
	 * @return True si se ha añadido al sistema False si no ha añadido
	 */
	
	public boolean notificarAltaSocio(Long idSocio);
	
	/**
	 * Funcion que modifica el Socio el cual se le pasa por parámetro
	 * @param idSocio
	 * @param socio
	 * @return Retorna true si se ha modificado con exito o False si no se ha podido modificar
	 */
	
	public boolean modificarSocio(Long idSocio,ObjetoSocio socio);
	
	/**
	 * Funcion que elimina al socio coincidente con la Id que se le pasa por parámetro
	 * @param idSocio
	 * @return Retorna True si el socio se ha eliminado con exito o False si no se ha podido eliminar
	 */
	
	public boolean eliminarSocio(Long idSocio);

}
