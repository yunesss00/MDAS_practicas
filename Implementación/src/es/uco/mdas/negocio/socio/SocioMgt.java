package es.uco.mdas.negocio.socio;

public interface SocioMgt {
    
	/**
     * Da de alta un abono
     * @param abono
     */
	
    public boolean darDeAltaAbono(ObjetoAbono abono);

    /**
     * Elimina un abono
     * @param idAbono
     */
    
    public boolean darDeBajaAbono(Long idAbono);

    /**
     * Cambia la fecha de expedicion de un abono
     * @param idAbono
     */
    
    public boolean renovarAbono(Long idAbono);

    /**
     * Muestra un abono
     * @param idAbono
     * @return
     */
    
    public ObjetoAbono obtenerInformacionAbono(Long idAbono);
    
    /**
	 * Funcion que introduce los datos de un nuevo socio en el sistema
	 * @param socio
	 * @return True si añade al socio con exito o False si no lo añade
	 */
    
    public boolean setDatosSocio(ObjetoSocio socio);
	
    /**
     * Funcion que comprueba si los Datos introducidos para el socio son correctos o no
     * @param socio
     * @return True si son correctos y False si son Incorrectos
     */
	public boolean comprobarValidezDatos(ObjetoSocio socio);
	
	/**
	 * Funcion que establece el tipo del socio que se le pasa como parámetro
	 * @param tipoSocio
	 * @param socio
	 * @return Retorna el socio con el tipo establecido
	 */
	
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio);
	
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
