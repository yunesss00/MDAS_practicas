package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;
import es.uco.mdas.negocio.clubDeportivo.datos.EntradaDatosImp;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadDatosImp;


public class ComprobarDisponibilidadLocalidadImp implements ComprobarDisponibilidadLocalidad{
	private ClubDeportivoMgtImp gestorClub;
	private BuscarLocalidadImp buscarLocalidad;
	
	public ComprobarDisponibilidadLocalidadImp() {
		this.gestorClub = new ClubDeportivoMgtImp(new LocalidadDatosImp(), new EntradaDatosImp());
	}
	
	@Override
	public boolean comprobarReservaLocalidad(Long idLocalidad) {
		if(buscarLocalidad.comprobarExistenciaLocalidad(idLocalidad))
			return gestorClub.comprobarReservaLocalidad(idLocalidad);
		return false;
	}

	@Override
	public String notificarDisponibilidadLocalidad(Long idLocalidad) {
		if(buscarLocalidad.comprobarExistenciaLocalidad(idLocalidad))
			return gestorClub.notificarDisponibilidadLocalidad(idLocalidad);
		return null;
	}


}
