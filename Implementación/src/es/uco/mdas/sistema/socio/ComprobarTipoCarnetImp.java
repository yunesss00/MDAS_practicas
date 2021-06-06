package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.TipoCarnet;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class ComprobarTipoCarnetImp implements ComprobarTipoCarnet {
	
	private SocioMgt gestorSocio;
	
	public ComprobarTipoCarnetImp() {
		this.gestorSocio = new SocioMgtImp(new AbonoDatosImp(), new SocioDatosImp());
	}

	@Override
	public long comprobarEdadSocio(Long idSocio) {
		return this.gestorSocio.comprobarEdadSocio(idSocio);	
	}

	@Override
	public TipoCarnet notificarTipoCarnet(long edad) {
		return this.gestorSocio.notificarTipoCarnet(edad);
	}

}
