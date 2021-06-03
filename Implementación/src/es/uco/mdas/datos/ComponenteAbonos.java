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
	private String nombreFicheroAbonosFutbol;
		
	private ComponenteAbonos() {
		nombreFicheroAbonosDisponibles = p.getFicheroAbonosDisponibles();
		nombreFicheroAbonosFutbol = p.getFicheroAbonosFutbol();
	}
	
	public static ComponenteAbonos getInstance() {
        if(instance == null) {
            instance = new ComponenteAbonos();
        }
        return instance;
    }
	
	public void darDeAltaAbono(Abono abono, Socio socio) {
		
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
				if (linea .contains(Long.toString(socio.getIdSocio())))
				{
					System.out.println("El socio ya dispone de este abono.");
					break;
				}
				
				FileWriter w = new FileWriter(f.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				
				if () 
				{
					
				}
			}
		
		}catch (IOException e) {}
	}
}
