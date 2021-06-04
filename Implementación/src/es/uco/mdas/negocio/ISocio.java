package es.uco.mdas.negocio;

import es.uco.mdas.negocio.socio.Abono;

public interface ISocio {
    
    public void darDeAltaAbono(Abono abono);

    public void darDeBajaAbono(Long idAbono);

    public void renovarAbono(Long idAbono);

    public Abono obtenerInformacionAbono(Long idAbono);
}
