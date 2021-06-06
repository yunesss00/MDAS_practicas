package es.uco.mdas.negocio.clubDeportivo;
import es.uco.mdas.negocio.clubDeportivo.datos.LocalidadAccesoDatos;
import es.uco.mdas.negocio.clubDeportivo.datos.EntradaAccesoDatos;

public class ClubDeportivoMgtImp implements ClubDeportivoMgt{
	private static final String RESERVADO = "RESERVADO";
	private LocalidadAccesoDatos localidadDatos;
	private EntradaAccesoDatos entradaDatos;
	
	public ClubDeportivoMgtImp(LocalidadAccesoDatos localidadDatos, EntradaAccesoDatos entradaDatos) {
        this.localidadDatos = localidadDatos;
        this.entradaDatos = entradaDatos;
    }

	@Override
	public boolean comprobarExistenciaLocalidad(Long idLocalidad) {
		if(localidadDatos.buscar(idLocalidad) == null) return false;
		return true;
	}

	@Override
	public ObjetoLocalidad mostrarDatosLocalidad(Long idLocalidad) {
		return localidadDatos.buscar(idLocalidad);
	}

	@Override
	public boolean comprobarReservaLocalidad(Long idLocalidad) {
		ObjetoLocalidad localidad = localidadDatos.buscar(idLocalidad);
		if(localidad.getEstado() == RESERVADO) return true;
		return false;
	}

	@Override
	public String notificarDisponibilidadLocalidad(Long idLocalidad) {
		ObjetoLocalidad localidad = localidadDatos.buscar(idLocalidad);
		return localidad.getEstado();
	}

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
