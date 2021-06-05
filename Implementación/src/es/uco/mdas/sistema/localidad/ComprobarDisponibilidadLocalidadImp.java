package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;


public class ComprobarDisponibilidadLocalidadImp implements ComprobarDisponibilidadLocalidad{
	private ClubDeportivoMgtImp gestorClub;
	private BuscarLocalidadImp buscarLocalidad;

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
