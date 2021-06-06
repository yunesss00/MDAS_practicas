package es.uco.mdas.sistema.socio;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.datos.AbonoAccesoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioAccesoDatosImp;

public class BuscarSocioImp implements BuscarSocio{
	private SocioMgt gestorSocio;
	
	public BuscarSocioImp() {
		this.gestorSocio = new SocioMgtImp(new AbonoAccesoDatosImp(), new SocioAccesoDatosImp());
	}

	@Override
	public boolean comprobarExistenciaSocio(Long idSocio) {
		return this.gestorSocio.comprobarExistenciaSocio(idSocio);	
	}

	@Override
	public ObjetoSocio mostrarDatosSocio(Long idSocio) {
		return this.gestorSocio.mostrarDatosSocio(idSocio);
	}

}
