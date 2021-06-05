package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadDatosImp;

public class ComprobarDisponibilidadLocalidadImp implements ComprobarDisponibilidadLocalidad{
	
	LocalidadDatosImp localidadDatos;
	String reservado = "RESERVADO";
	String disponible = "DISPONIBLE";

	@Override
	public boolean comprobarReservaLocalidad(Long idLocalidad) {
		ObjetoLocalidad localidad = localidadDatos.buscar(idLocalidad);
		if(localidad.getEstado() == reservado) return true;
		return false;
	}

	@Override
	public String notificarDisponibilidadLocalidad(Long idLocalidad) {
		ObjetoLocalidad localidad = localidadDatos.buscar(idLocalidad);
		return localidad.getEstado();
	}


}
