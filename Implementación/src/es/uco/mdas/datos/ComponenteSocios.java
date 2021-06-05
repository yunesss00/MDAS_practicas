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


public class ComponenteSocios extends Socio implements IBuscarSocio, IComprobarTipoCarnet, IRegistrarSocio {

	public ComponenteSocios(Long idSocio, String nombreSocio, String apellidosSocio, Date fechaNacimientoSocio, int antiguedadSocio) {
		super(idSocio, nombreSocio, apellidosSocio, fechaNacimientoSocio, antiguedadSocio);
	}

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
