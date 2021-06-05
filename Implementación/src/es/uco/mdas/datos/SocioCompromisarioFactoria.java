package es.uco.mdas.datos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SocioCompromisarioFactoria implements IBuscarSocio, IComprobarTipoCarnet, IRegistrarSocio {
	
	@Override
	public void setDatosSocio(ObjetoSocio socio) {
		
		SocioCompromisario socioCompromisario = new SocioCompromisario(socio.getIdSocio(), socio.getNombreSocio(), socio.getApellidosSocio(),
		socio.getFechaNacimientoSocio(), socio.getAntiguedadSocio());
		
		fichero.guardarSocio(socioCompromisario);
		
	}

	@Override
	public boolean comprobarValidezDatos(ObjetoSocio socio) {
		
		
		return false;
	}

	@Override
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long comprobarEdadSocio(ObjetoSocio socio) {
		
		comprobarExistenciaSocio(socio.getIdSocio());
		ObjetoSocio socioAuxiliar = mostrarDatosSocio(socio.getIdSocio());
		
	    LocalDate hoy = LocalDate.now();
	    LocalDate nacimiento = socioAuxiliar.getFechaNacimientoSocio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
	        
	    return edad;
	}
		

	@Override
	public String notificarTipoCarnet(ObjetoSocio socio) {
		
		
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
