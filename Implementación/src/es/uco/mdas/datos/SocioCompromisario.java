package es.uco.mdas.datos;

import java.util.Date;

public class SocioCompromisario extends Socio {

	private Long voto;
	
	public SocioCompromisario(Long idSocio, String nombreSocio, String apellidosSocio, Date fechaNacimientoSocio,
			int antiguedadSocio) {
		super(idSocio, nombreSocio, apellidosSocio, fechaNacimientoSocio, antiguedadSocio);
		voto = null;
	}
	
	public Long getVoto() {
		
		return voto;
	}
	
	public void setVoto(Long voto) {
		
		voto = voto;
	}
	

}
