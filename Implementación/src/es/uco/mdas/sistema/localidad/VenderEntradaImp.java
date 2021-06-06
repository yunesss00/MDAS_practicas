package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;
import es.uco.mdas.negocio.clubDeportivo.datos.EntradaDatosImp;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadDatosImp;


public class VenderEntradaImp implements VenderEntrada {
	
	private ClubDeportivoMgtImp gestorClub;
	private BuscarLocalidadImp buscarLocalidad;
	
	public VenderEntradaImp() {
		this.gestorClub = new ClubDeportivoMgtImp(new LocalidadDatosImp(), new EntradaDatosImp());
	}
	
	@Override
	public void actualizarLocalidad(Long idLocalidad) {
		if(buscarLocalidad.comprobarExistenciaLocalidad(idLocalidad))
			gestorClub.actualizarLocalidad(idLocalidad);
	}

	@Override
	public String notificarPago(Long idLocalidad) {
		return gestorClub.notificarPago(idLocalidad);
	}

}
