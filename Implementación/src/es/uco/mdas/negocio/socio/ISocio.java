package es.uco.mdas.negocio.socio;

public interface ISocio {
    
    public boolean darDeAltaAbono(Abono abono);

    public boolean darDeBajaAbono(Long idAbono);

    public boolean renovarAbono(Long idAbono);

    public Abono obtenerInformacionAbono(Long idAbono);
}
