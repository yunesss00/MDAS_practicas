package es.uco.mdas.datos;

import java.util.Date;

public class SocioAbonado extends ObjetoSocio{
	
	private ObjetoAbono abono;

	public SocioAbonado(Long idSocio, String nombreSocio, String apellidosSocio, Date fechaNacimientoSocio,
			int antiguedadSocio, ObjetoAbono abono) {
		super(idSocio, nombreSocio, apellidosSocio, fechaNacimientoSocio, antiguedadSocio);
	}

	public ObjetoAbono getAbono() {
		return abono;
	}

	public void setAbono(ObjetoAbono abono) {
		this.abono = abono;
	}

		
}
