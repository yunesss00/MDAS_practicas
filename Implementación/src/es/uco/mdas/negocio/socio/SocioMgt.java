package es.uco.mdas.negocio.socio;

public interface SocioMgt {
    
    public boolean darDeAltaAbono(ObjetoAbono abono);

    public boolean darDeBajaAbono(Long idAbono);

    public boolean renovarAbono(Long idAbono);

    public ObjetoAbono obtenerInformacionAbono(Long idAbono);
    
    public boolean setDatosSocio(ObjetoSocio socio);
	
	public boolean comprobarValidezDatos(ObjetoSocio socio);
	
	public ObjetoSocio setTipoSocio(String tipoSocio, ObjetoSocio socio);
	
	public boolean comprobarExistenciaSocio(Long idSocio);
	
	public ObjetoSocio mostrarDatosSocio(Long idSocio);
	
	public long comprobarEdadSocio(Long idSocio);
	
	public TipoCarnet notificarTipoCarnet(long edad);
	
	public boolean modificarSocio(Long idSocio,ObjetoSocio socio);

}
