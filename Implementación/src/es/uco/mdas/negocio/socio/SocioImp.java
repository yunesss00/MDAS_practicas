package es.uco.mdas.negocio;

import java.net.SocketOption;

import es.uco.mdas.negocio.socio.Abono;
import es.uco.mdas.negocio.socio.ISocio;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.IAbonoDatos;
import es.uco.mdas.negocio.socio.datos.ISocioDatos;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class SocioImp implements ISocio{

    private IAbonoDatos abonoDatos;
    private ISocioDatos socioDatos;

    public SocioImp(IAbonoDatos abonoDatos, ISocioDatos socioDatos) {
        this.abonoDatos = abonoDatos;
        this.socioDatos = socioDatos;
    }

    @Override
    public boolean darDeAltaAbono(Abono abono) {
        if (abonoDatos.consutarPorID(abono.getIdAbono()) == null) 
        {
            
        }
        
    }

    @Override
    public boolean darDeBajaAbono(Long idAbono) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean renovarAbono(Long idAbono) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Abono obtenerInformacionAbono(Long idAbono) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
