package es.uco.mdas.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import es.uco.mdas.datos.Abono;
import es.uco.mdas.datos.Socio;
import es.uco.mdas.datos.PropertiesFile;

public class ComponenteAbonos extends Abono{

	private static ComponenteAbonos instance = null;
	
	private PropertiesFile p = new PropertiesFile();
	private String nombreFicheroAbonosDisponibles;
	private String tiposAbono;
	private String deportesAbono;
		
	private ComponenteAbonos() {
		nombreFicheroAbonosDisponibles = p.getFicheroAbonosDisponibles();
		tiposAbono = p.getTiposAbono();
		deportesAbono = p.getDeportesAbono();
	}
	
	public static ComponenteAbonos getInstance() {
        if(instance == null) {
            instance = new ComponenteAbonos();
        }
        return instance;
    }
	/**
	 * Es correcto si el deporte y el tipo de abono existen en el sistema
	 * @param abono
	 * @return validación
	 */
	public Boolean comprobarDatosAbono(Abono abono) {
		
		if (tiposAbono.contains(abono.getTipoAbono()) && 
				deportesAbono.contains(abono.getDeporteAbono())) return true;
		return false;

	}
	/**
	 * Da de alta un abono de un tipo y deporte determinados.
	 * @param abono
	 * @param idSocio
	 */
	public void darDeAltaAbono(Abono abono, Long idSocio) {
		
		File f;
		String nombreFichero = "abonos" + abono.getDeporteAbono() + ".txt"; 
		f= new File(nombreFichero);
		
		try {
			
			if(!f.exists()) 
			{	
				f.createNewFile();
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			
			while((linea = reader.readLine()) != null) 
			{
				if (linea .contains(Long.toString(idSocio)))
				{
					System.out.println("El socio ya dispone de este abono.");
					break;
				}
				
				FileWriter w = new FileWriter(f.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				
				if (comprobarDatosAbono(abono)) 
				{
					wr.append(abono.getIdAbono() + "_" + idSocio + "\n");
				}
				else 
				{
					System.out.println("El deporte o el tipo de abono son incorrectos.");
				}
				
				wr.close();
				bw.close();
			}
		
		}catch (IOException e) {}
	}
}
