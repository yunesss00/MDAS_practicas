package es.uco.mdas.negocio.socio.datos;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Redefinición de la clase ObjectOutputStream para que no escriba una cabecera
 * al inicio del Stream.
 * @author crist
 *
 */

public class MiObjectOutputStream extends ObjectOutputStream {
	
	public MiObjectOutputStream(OutputStream out) throws IOException{
		super(out);
	}
	
	protected MiObjectOutputStream() throws IOException, SecurityException{
		super();
	}
	
	protected void writeStreamHeader() throws IOException {
		
	}
}
