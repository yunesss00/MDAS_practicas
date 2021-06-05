package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgt;

public class BuscarSocioImp implements BuscarSocio{
	
	private SocioMgt gestorSocio;

	@Override
	public boolean comprobarExistenciaSocio(Long idSocio) {
		this.gestorSocio.comprobarExistenciaSocio(idSocio);
		return false;
	}

	@Override
	public ObjetoSocio mostrarDatosSocio(Long idSocio) {
		return this.gestorSocio.mostrarDatosSocio(idSocio);
	}

}
