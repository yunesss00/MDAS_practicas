package es.uco.mdas.sistema.localidad;

import es.uco.mdas.negocio.clubDeportivo.ObjetoEntrada;

public interface VenderEntrada {
	
	public void actualizarLocalidad(Long idLocalidad);
	
	public String notificarPago(Long idLocalidad);
	
	public boolean setDatosEntrada(ObjetoEntrada entrada);
}
