package es.uco.mdas.sistema.localidad;

public interface VenderEntrada {
	
	public void actualizarLocalidad(Long idLocalidad);
	
	public String notificarPago(Long idLocalidad);
}
