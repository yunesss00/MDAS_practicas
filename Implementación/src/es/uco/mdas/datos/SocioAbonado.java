package es.uco.mdas.datos;

import java.util.Date;

public class SocioAbonado extends Socio{
	
	private Abono abono;

	public SocioAbonado(Long idSocio, String nombreSocio, String apellidosSocio, Date fechaNacimientoSocio,
			int antiguedadSocio, Abono abono) {
		super(idSocio, nombreSocio, apellidosSocio, fechaNacimientoSocio, antiguedadSocio);
	}

	public Abono getAbono() {
		return abono;
	}

	public void setAbono(Abono abono) {
		this.abono = abono;
	}

		
}
