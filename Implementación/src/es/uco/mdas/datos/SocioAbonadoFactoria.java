package es.uco.mdas.datos;

import java.util.Date;

public class SocioAbonadoFactoria implements IBuscarSocio, IComprobarTipoCarnet, IRegistrarSocio{

	@Override
	public void setDatosSocio(ObjetoSocio socio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean comprobarValidezDatos(ObjetoSocio socio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long comprobarEdadSocio(ObjetoSocio socio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String notificarTipoCarnet(ObjetoSocio socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean comprobarExistenciaSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjetoSocio mostrarDatosSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return null;
	}

}
