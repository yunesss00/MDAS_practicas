package es.uco.mdas.sistema.abono;

import es.uco.mdas.negocio.socio.Abono;

public interface IAbono {

    public void darDeAltaAbono(Abono abono);

    public void darDeBajaAbono(Long idAbono);

    public void renovarAbono(Long idAbono);
    
    public Abono obtenerInformacionAbono(Long idAbono);
}
