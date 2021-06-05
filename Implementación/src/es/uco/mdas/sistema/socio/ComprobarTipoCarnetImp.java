package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.TipoCarnet;

public class ComprobarTipoCarnetImp implements ComprobarTipoCarnet {
	
	private SocioMgt gestorSocio;

	@Override
	public long comprobarEdadSocio(Long idSocio) {
		return this.gestorSocio.comprobarEdadSocio(idSocio);	
	}

	@Override
	public TipoCarnet notificarTipoCarnet(long edad) {
		return this.gestorSocio.notificarTipoCarnet(edad);
	}

}
