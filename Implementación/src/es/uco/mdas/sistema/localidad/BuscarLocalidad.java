package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;

public interface BuscarLocalidad {
	
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
	
}
