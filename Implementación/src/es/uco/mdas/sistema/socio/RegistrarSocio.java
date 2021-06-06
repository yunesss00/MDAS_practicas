package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;

public interface RegistrarSocio {

	public boolean setDatosSocio(ObjetoSocio socio);
	
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio);
	
	public boolean notificarAltaSocio(Long idSocio);
	
	public boolean modificarSocio(Long idSocio,ObjetoSocio socio);

}
