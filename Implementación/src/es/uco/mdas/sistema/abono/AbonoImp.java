package es.uco.mdas.sistema.abono;

import es.uco.mdas.negocio.SocioImp;
import es.uco.mdas.negocio.clubDeportivo.IGestorAbonos;
import es.uco.mdas.negocio.socio.Abono;
import es.uco.mdas.negocio.socio.ISocio;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class AbonoImp implements IAbono{

    private ISocio gestorSocio;
    //private IGestorAbonos gestorAbono;

    public AbonoImp(){
        this.gestorSocio = new SocioImp(new AbonoDatosImp(), new SocioDatosImp());
    }

    @Override
    public boolean darDeAltaAbono(Abono abono) {
        return gestorSocio.darDeAltaAbono(abono);
        
    }

    @Override
    public boolean darDeBajaAbono(Long idAbono) {
        return gestorSocio.darDeBajaAbono(idAbono);
        
    }

    @Override
    public boolean renovarAbono(Long idAbono) {
        return gestorSocio.renovarAbono(idAbono);        
    }

    @Override
    public Abono obtenerInformacionAbono(Long idSocio) {
        Abono abono = gestorSocio.obtenerInformacionAbono(idSocio);
        return abono;
    }
    
}
