package es.uco.mdas.negocio.socio;

import java.net.SocketOption;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.ObjetoAbono;
import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.AbonoDatos;
import es.uco.mdas.negocio.socio.datos.SocioDatos;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class SocioImp implements SocioMgt{

    private AbonoDatos abonoDatos;
    private SocioDatos socioDatos;

    public SocioImp(AbonoDatos abonoDatos, SocioDatos socioDatos) {
        this.abonoDatos = abonoDatos;
        this.socioDatos = socioDatos;
    }

    @Override
    public boolean darDeAltaAbono(ObjetoAbono abono) {
        ObjetoAbono informacionAbono = obtenerInformacionAbono(abono.getIdAbono());
        if (informacionAbono == null) return abonoDatos.insertar(abono);
        return false;
        
        
    }

    @Override
    public boolean darDeBajaAbono(Long idAbono) {
        ObjetoAbono informacionAbono = obtenerInformacionAbono(idAbono);
        if(informacionAbono == null) return false;
        return abonoDatos.borrar(informacionAbono);
    }

    @Override
    public boolean renovarAbono(Long idAbono) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ObjetoAbono obtenerInformacionAbono(Long idAbono) {
        ObjetoAbono informacionAbono = abonoDatos.buscar(idAbono);
        return informacionAbono;
    }

	@Override
	public boolean setDatosSocio(ObjetoSocio socio) {
		return socioDatos.insertar(socio);		
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
	public boolean comprobarExistenciaSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjetoSocio mostrarDatosSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long comprobarEdadSocio(Long idSocio) {
		if(!comprobarExistenciaSocio(idSocio)) return 0;
		ObjetoSocio socio = mostrarDatosSocio(idSocio);
		
	    LocalDate hoy = LocalDate.now();
	    LocalDate nacimiento = socio.getFechaNacimientoSocio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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
    
}
