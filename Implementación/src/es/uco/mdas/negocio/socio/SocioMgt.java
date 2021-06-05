package es.uco.mdas.negocio.socio;

public interface SocioMgt {
    
    public boolean darDeAltaAbono(Abono abono);

    public boolean darDeBajaAbono(Abono abono);

    public boolean renovarAbono(Long idAbono);

    public Abono obtenerInformacionAbono(Long idAbono);
    
    public void setDatosSocio(Socio socio);
	
	public boolean comprobarValidezDatos(Socio socio);
	
	public Socio setTipoSocio(String tipoSocio, Socio socio);
	
	public boolean comprobarExistenciaSocio(Long idSocio);
	
	public Socio mostrarDatosSocio(Long idSocio);
	
	public long comprobarEdadSocio(Socio socio);
	
	public String notificarTipoCarnet(Socio socio);
}
