package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ClubDeportivoMgtImp;
import es.uco.mdas.negocio.clubDeportivo.ObjetoEntrada;
import es.uco.mdas.negocio.clubDeportivo.datos.EntradaAccesoDatosImp;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadAccesoDatosImp;


public class VenderEntradaImp implements VenderEntrada {
	
	private ClubDeportivoMgtImp gestorClub;
	private BuscarLocalidadImp buscarLocalidad;
	
	public VenderEntradaImp() {
		this.gestorClub = new ClubDeportivoMgtImp(new LocalidadAccesoDatosImp(), new EntradaAccesoDatosImp());
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

	@Override
	public boolean setDatosEntrada(ObjetoEntrada entrada) {
		return gestorClub.setDatosEntrada(entrada);
	}

	@Override
	public boolean existeEntrada(Long idlocalidad) {
		
		return gestorClub.existeEntrada(idlocalidad);
	}

}
