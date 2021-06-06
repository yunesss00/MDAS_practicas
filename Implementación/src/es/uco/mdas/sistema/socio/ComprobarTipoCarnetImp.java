package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.TipoCarnet;
import es.uco.mdas.negocio.socio.datos.AbonoAccesoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioAccesoDatosImp;

public class ComprobarTipoCarnetImp implements ComprobarTipoCarnet {
	
	private SocioMgt gestorSocio;
	
	public ComprobarTipoCarnetImp() {
		this.gestorSocio = new SocioMgtImp(new AbonoAccesoDatosImp(), new SocioAccesoDatosImp());
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
