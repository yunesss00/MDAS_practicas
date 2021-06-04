package es.uco.mdas.sistema.abono;

import es.uco.mdas.negocio.socio.Abono;

public interface IAbono {
    /**
     * Da de alta un abono
     * @param abono
     */
    public void darDeAltaAbono(Abono abono);

    /**
     * Elimina un abono
     * @param idAbono
     */
    public void darDeBajaAbono(Long idAbono);

    /**
     * Cambia la fecha de expedicion de un abono
     * @param idAbono
     */
    public void renovarAbono(Long idAbono);
    
    /**
     * Muestra un abono
     * @param idAbono
     * @return
     */
    public Abono obtenerInformacionAbono(Long idAbono);
}
