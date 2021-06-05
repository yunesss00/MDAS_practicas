package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.TipoCarnet;

public interface ComprobarTipoCarnet {

	public long comprobarEdadSocio(Long idSocio);
	
	public TipoCarnet notificarTipoCarnet(long edad);
}
