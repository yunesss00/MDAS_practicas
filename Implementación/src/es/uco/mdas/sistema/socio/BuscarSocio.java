package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;

public interface BuscarSocio {
	
	public boolean comprobarExistenciaSocio(Long idSocio);
	
	public ObjetoSocio mostrarDatosSocio(Long idSocio);

}
