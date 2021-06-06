package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class RegistrarSocioImp implements RegistrarSocio{	
	private SocioMgt gestorSocio;

	public RegistrarSocioImp() {
		this.gestorSocio = new SocioMgtImp(new AbonoDatosImp(), new SocioDatosImp());
	}

	@Override
	public boolean setDatosSocio(ObjetoSocio socio) {
		return this.gestorSocio.setDatosSocio(socio);
	}

	@Override
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio) {
		return this.gestorSocio.setTipoSocio(tipoSocio, socio);
	}

	@Override
	public boolean notificarAltaSocio(Long idSocio) {
		return true;
	}

}
