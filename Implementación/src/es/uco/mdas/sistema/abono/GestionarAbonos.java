package es.uco.mdas.sistema.abono;

import es.uco.mdas.negocio.socio.ObjetoAbono;

public interface GestionarAbonos {
    /**
     * Da de alta un abono
     * @param abono
     */
    public boolean darDeAltaAbono(ObjetoAbono abono);

    /**
     * Elimina un abono
     * @param idAbono
     */
    public boolean darDeBajaAbono(Long idSocio);

    /**
     * Cambia la fecha de expedicion de un abono
     * @param idAbono
     */
    public boolean renovarAbono(Long idAbono);
    
    /**
     * Muestra un abono
     * @param idAbono
     * @return
     */
    public ObjetoAbono obtenerInformacionAbono(Long idAbono);
}
