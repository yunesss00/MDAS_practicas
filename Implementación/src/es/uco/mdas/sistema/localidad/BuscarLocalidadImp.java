package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadDatosImp;

public class BuscarLocalidadImp implements BuscarLocalidad {
	
	LocalidadDatosImp localidadDatos;

	@Override
	public boolean comprobarExistenciaLocalidad(Long idLocalidad) {
		if(localidadDatos.buscar(idLocalidad) == null) return false;
		return true;
	}

	@Override
	public ObjetoLocalidad mostrarDatosLocalidad(Long idLocalidad) {
		return localidadDatos.buscar(idLocalidad);
	}

	

}
