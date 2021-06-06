package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class BuscarSocioImp implements BuscarSocio{
	private SocioMgt gestorSocio;
	
	public BuscarSocioImp() {
		this.gestorSocio = new SocioMgtImp(new AbonoDatosImp(), new SocioDatosImp());
	}

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
