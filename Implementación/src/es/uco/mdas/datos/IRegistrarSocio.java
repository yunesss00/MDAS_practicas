package es.uco.mdas.datos;

/*
 * Interfaz de registro de socios
 * 
 */
public interface IRegistrarSocio {
	
	public void setDatosSocio(Socio socio);
	
	public boolean comprobarValidezDatos(Socio socio);
	
	public Socio setTipoSocio(String tipoSocio, Socio socio);

}
