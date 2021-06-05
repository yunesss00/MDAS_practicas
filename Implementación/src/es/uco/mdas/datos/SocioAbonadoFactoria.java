package es.uco.mdas.datos;

import java.util.Date;

public class SocioAbonadoFactoria implements IBuscarSocio, IComprobarTipoCarnet, IRegistrarSocio{

	@Override
	public void setDatosSocio(Socio socio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprobarValidezDatos(Socio socio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Socio setTipoSocio(String tipoSocio, Socio socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long comprobarEdadSocio(Socio socio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String notificarTipoCarnet(Socio socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean comprobarExistenciaSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Socio mostrarDatosSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return null;
	}

}
