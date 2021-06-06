package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;

public interface BuscarSocio {
	
	/**
	 * Funcion que sirve para comprobar la Existencia de un socio en el sistema
	 * @param idSocio
	 * @return Retorna True si el socio existe y False si el socio no existe
	 */
	
	public boolean comprobarExistenciaSocio(Long idSocio);
	
	/**
	 * Funcion que sirve para obtener los Datos de un Socio del sistema
	 * @param idSocio
	 * @return Retorna el socio coincidente co la id que se pasa como parámetro
	 */ 
	
	public ObjetoSocio mostrarDatosSocio(Long idSocio);

}
