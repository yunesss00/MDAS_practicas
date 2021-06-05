package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadDatosImp;

public class VenderEntradaImp implements VenderEntrada {
	
	LocalidadDatosImp localidadDatos;
	private static final String RESERVADO = "RESERVADO";
	
	@Override
	public void actualizarLocalidad(Long idLocalidad) {
		ObjetoLocalidad localidad = localidadDatos.buscar(idLocalidad);
		localidad.setEstado(RESERVADO);	
	}

	@Override
	public String notificarPago(Long idLocalidad) {
		ObjetoLocalidad localidad = localidadDatos.buscar(idLocalidad);
		return localidad.infoLocalidad();
	}

}
