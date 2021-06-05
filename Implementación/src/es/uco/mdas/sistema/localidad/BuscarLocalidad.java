package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;

public interface BuscarLocalidad {

	public boolean comprobarExistenciaLocalidad(Long idLocalidad);
	
	public ObjetoLocalidad mostrarDatosLocalidad(Long idLocalidad);
	
}
