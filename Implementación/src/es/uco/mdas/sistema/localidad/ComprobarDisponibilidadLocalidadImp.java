package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;
import es.uco.mdas.negocio.clubDeportivo.datos.EntradaAccesoDatosImp;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadAccesoDatosImp;


public class ComprobarDisponibilidadLocalidadImp implements ComprobarDisponibilidadLocalidad{
	private ClubDeportivoMgtImp gestorClub;
	private BuscarLocalidadImp buscarLocalidad;
	
	public ComprobarDisponibilidadLocalidadImp() {
		this.gestorClub = new ClubDeportivoMgtImp(new LocalidadAccesoDatosImp(), new EntradaAccesoDatosImp());
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
