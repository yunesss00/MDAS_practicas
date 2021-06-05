package es.uco.mdas.negocio.socio;

import java.net.SocketOption;

import es.uco.mdas.negocio.socio.Abono;
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
    public boolean darDeAltaAbono(Abono abono) {

		return abonoDatos.insertar(abono);
        
    }

    @Override
    public boolean darDeBajaAbono(Long idAbono) {
        Abono informacionAbono = obtenerInformacionAbono(idAbono);
        if(informacionAbono == null) return false;
        return abonoDatos.borrar(informacionAbono);
    }

    @Override
    public boolean renovarAbono(Long idAbono) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Abono obtenerInformacionAbono(Long idAbono) {
        Abono informacionAbono = abonoDatos.buscar(idAbono);
        return informacionAbono;
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
	public boolean comprobarExistenciaSocio(Long idSocio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Socio mostrarDatosSocio(Long idSocio) {
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
    
}
