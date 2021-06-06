package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.datos.AbonoAccesoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioAccesoDatosImp;

public class RegistrarSocioImp implements RegistrarSocio{	
	private SocioMgt gestorSocio;

	public RegistrarSocioImp() {
		this.gestorSocio = new SocioMgtImp(new AbonoAccesoDatosImp(), new SocioAccesoDatosImp());
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

	@Override
	public boolean modificarSocio(Long idSocio,ObjetoSocio socio) {
		return this.gestorSocio.modificarSocio(idSocio,socio);
	}

	@Override
	public boolean eliminarSocio(Long idSocio) {
		return this.gestorSocio.eliminarSocio(idSocio);
	}

}
