package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;
import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;
import es.uco.mdas.negocio.clubDeportivo.datos.EntradaAccesoDatosImp;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadAccesoDatosImp;


public class BuscarLocalidadImp implements BuscarLocalidad {
	
	private ClubDeportivoMgtImp gestorClub;
	
	public BuscarLocalidadImp() {
		this.gestorClub = new ClubDeportivoMgtImp(new LocalidadAccesoDatosImp(), new EntradaAccesoDatosImp());
	}

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
