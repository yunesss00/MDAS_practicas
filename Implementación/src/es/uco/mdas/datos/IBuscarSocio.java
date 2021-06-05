package es.uco.mdas.datos;

public interface IBuscarSocio {
	
	public boolean comprobarExistenciaSocio(Long idSocio);
	
	public ObjetoSocio mostrarDatosSocio(Long idSocio);

}
