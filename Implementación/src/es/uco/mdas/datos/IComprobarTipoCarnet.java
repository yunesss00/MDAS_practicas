package es.uco.mdas.datos;

/*
 * interfaz de comprobacion de carnets
 * 
 */
public interface IComprobarTipoCarnet {
	
	public long comprobarEdadSocio(ObjetoSocio socio);
	
	public String notificarTipoCarnet(ObjetoSocio socio);
	

}
