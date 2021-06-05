package es.uco.mdas.datos;

/*
 * Interfaz de registro de socios
 * 
 */
public interface IRegistrarSocio {
	
	public void setDatosSocio(ObjetoSocio socio);
	
	public boolean comprobarValidezDatos(ObjetoSocio socio);
	
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio);

}
