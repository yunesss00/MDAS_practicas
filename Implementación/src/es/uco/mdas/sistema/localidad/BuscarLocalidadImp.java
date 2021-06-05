package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;
import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;


public class BuscarLocalidadImp implements BuscarLocalidad {
	
	private ClubDeportivoMgtImp gestorClub;

	@Override
	public boolean comprobarExistenciaLocalidad(Long idLocalidad) {
		return gestorClub.comprobarExistenciaLocalidad(idLocalidad);
	}

	@Override
	public ObjetoLocalidad mostrarDatosLocalidad(Long idLocalidad) {
		if(comprobarExistenciaLocalidad(idLocalidad))
			return gestorClub.mostrarDatosLocalidad(idLocalidad);
		return null;
	}

	

}
