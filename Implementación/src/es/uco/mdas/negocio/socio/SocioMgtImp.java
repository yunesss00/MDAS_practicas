package es.uco.mdas.negocio.socio;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import es.uco.mdas.negocio.socio.datos.AbonoAccesoDatos;
import es.uco.mdas.negocio.socio.datos.SocioAccesoDatos;

public class SocioMgtImp implements SocioMgt{

    private AbonoAccesoDatos abonoDatos;
    private SocioAccesoDatos socioDatos;

    public SocioMgtImp(AbonoAccesoDatos abonoDatos, SocioAccesoDatos socioDatos) {
        this.abonoDatos = abonoDatos;
        this.socioDatos = socioDatos;
    }

    @Override
    public boolean darDeAltaAbono(ObjetoAbono abono) {
    	abono.calcularIdAleatoria();
        abono.setFechaExpedicionAbono();
		abono.setLocalidad();
        return abonoDatos.insertar(abono);
    }

    @Override
    public boolean darDeBajaAbono(Long idAbono) {
        ObjetoAbono informacionAbono = obtenerInformacionAbono(idAbono);
        if(informacionAbono == null) return false;
        return abonoDatos.borrar(idAbono);
    }

    @Override
    public boolean renovarAbono(Long idAbono) {
        ObjetoAbono informacionAbono = obtenerInformacionAbono(idAbono);
		if (informacionAbono == null) return false; 
		informacionAbono.setFechaExpedicionAbono();
        return abonoDatos.modificar(informacionAbono);
    }

    @Override
    public ObjetoAbono obtenerInformacionAbono(Long idAbono) {
        ObjetoAbono informacionAbono = abonoDatos.buscar(idAbono);
        return informacionAbono;
    }

	@Override
	public boolean setDatosSocio(ObjetoSocio socio) {
		socio.calcularIdAleatoria();
		return socioDatos.insertar(socio);		
	}

	@Override
	public boolean comprobarValidezDatos(ObjetoSocio socio) {
		return true;
	}

	@Override
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio) {
		return null;
	}

	@Override
	public boolean comprobarExistenciaSocio(Long idSocio) {
		if(socioDatos.buscar(idSocio)==null) return false;
		return true;
	}

	@Override
	public ObjetoSocio mostrarDatosSocio(Long idSocio) {
		return socioDatos.buscar(idSocio);
	}

	@Override
	public long comprobarEdadSocio(Long idSocio) {
		if(!comprobarExistenciaSocio(idSocio)) return 0;
		ObjetoSocio socio = mostrarDatosSocio(idSocio);
		
	    LocalDate hoy = LocalDate.now();
	    LocalDate nacimiento = socio.getFechaNacimientoSocio()
	    		.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
	        
	    return edad;
	}

	@Override
	public TipoCarnet notificarTipoCarnet(long edad) {
		long edadSocioAdulto = 18;
		long edadSocioOro = 65;
		TipoCarnet tipoCarnet;
		
		if(edad >= edadSocioOro) {
			tipoCarnet = TipoCarnet.Oro;
		}
		else {
			if(edad >= edadSocioAdulto) {
				tipoCarnet = TipoCarnet.Adulto;
			}
			else {
				tipoCarnet = TipoCarnet.Infantil;
			}
		}
		return tipoCarnet;
	}

	@Override
	public boolean modificarSocio(Long idSocio,ObjetoSocio socio) {
		ObjetoSocio socioAuxiliar = socioDatos.buscar(idSocio);
		socio.setIdSocio(socioAuxiliar.getIdSocio());
		return socioDatos.modificar(socio);
	}

	@Override
	public boolean eliminarSocio(Long idSocio) {
		return socioDatos.borrar(idSocio);
	}
    
}
