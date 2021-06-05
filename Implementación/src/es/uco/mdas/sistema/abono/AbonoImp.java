package es.uco.mdas.sistema.abono;

import es.uco.mdas.negocio.socio.ObjetoAbono;
import es.uco.mdas.negocio.socio.SocioMgt;
import es.uco.mdas.negocio.socio.SocioImp;
import es.uco.mdas.negocio.socio.datos.AbonoDatosImp;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;

public class AbonoImp implements IAbono{

    private SocioMgt gestorSocio;
    //private IGestorAbonos gestorAbono;

    public AbonoImp(){
        this.gestorSocio = new SocioImp(new AbonoDatosImp(), new SocioDatosImp());
    }

    @Override
    public boolean darDeAltaAbono(ObjetoAbono abono) {
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
    public ObjetoAbono obtenerInformacionAbono(Long idAbono) {
        ObjetoAbono abono = gestorSocio.obtenerInformacionAbono(idAbono);
        return abono;
    }
    
}
