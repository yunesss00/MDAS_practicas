package es.uco.mdas.datos;

import es.uco.mdas.datos.Abono;
import es.uco.mdas.datos.Socio;
import es.uco.mdas.datos.PropertiesFile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class ComponenteSocios extends ObjetoSocio implements IBuscarSocio, IComprobarTipoCarnet, IRegistrarSocio {

	public ComponenteSocios(Long idSocio, String nombreSocio, String apellidosSocio, Date fechaNacimientoSocio, int antiguedadSocio) {
		super(idSocio, nombreSocio, apellidosSocio, fechaNacimientoSocio, antiguedadSocio);
	}

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
