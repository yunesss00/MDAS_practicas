package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.TipoCarnet;

public interface ComprobarTipoCarnet {
	
	/**
	 * Funcion que calcula la Edad del socio coincidente con la ID que se le pasa por parámetros
	 * @param idSocio
	 * @return Retorna la edad del socio
	 */

	public long comprobarEdadSocio(Long idSocio);
	
	/**
	 * Función que notifica con el Tipo de Carnet que se aplica segun la edad Del socio
	 * @param edad
	 * @return Retorna el tipo de carnet que se debe aplicar respecto a la Edad que se le pasa por 
	 * parámetro
	 */
	
	public TipoCarnet notificarTipoCarnet(long edad);
}
