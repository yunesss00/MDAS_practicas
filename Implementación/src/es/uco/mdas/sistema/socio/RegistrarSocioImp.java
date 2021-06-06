package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgt;

public class RegistrarSocioImp implements RegistrarSocio{
	
	private SocioMgt gestorSocio;
	
	public RegistrarSocioImp() {
		this.gestorSocio = new ClubDeportivoMgtImp(new RegistarSocioImp());
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
