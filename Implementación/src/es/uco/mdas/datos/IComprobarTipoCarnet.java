package es.uco.mdas.datos;

/*
 * interfaz de comprobacion de carnets
 * 
 */
public interface IComprobarTipoCarnet {
	
	public long comprobarEdadSocio(Socio socio);
	
	public String notificarTipoCarnet(Socio socio);
	

}
