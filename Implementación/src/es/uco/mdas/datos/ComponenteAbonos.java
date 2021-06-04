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
        if(instance == null) 
        {
            instance = new ComponenteAbonos();
        }
        return instance;
    }
	
	/**
	 * Si no quedan abonos return false, si quedan return true
	 * @param deporte
	 * @return
	 */
	public Boolean comprobarDisponibilidadAbono(String deporte) {
		File f;
		String nombreFichero = nombreFicheroAbonosDisponibles; 
		f= new File(nombreFichero);
		
		try {
			
			if (!f.exists()) 
			{
				System.out.println("No existe el fichero que busca.");
				return false;
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			System.out.println("Comprobando numero de abonos disponibles");
			String[] partes;
			
			while((linea = reader.readLine()) != null)
			{
				
				partes = linea.split("-");
				linea = partes[1];
			
				if(partes[0] == deporte && linea.trim().equals(Integer.toString(0)))
					return false;
			}
			reader.close();
		
		}catch(IOException e) {}
		return true;
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
	 * Si encuentra la id del socio return true, si no retun false,
	 * si no encuentra el archivo return false
	 * @param abono
	 * @param idSocio
	 * @return
	 */
	public Boolean comprobarExistenciaAbono(Abono abono, Long idSocio) {
		File f;
		String nombreFichero = "abonos" + abono.getDeporteAbono() + ".txt"; 
		f= new File(nombreFichero);
		
		try {
			
			if (!f.exists()) 
			{
				System.out.println("No existe el fichero que busca.");
				return false;
			}
			
			BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			String[] partes;
			System.out.println("Comprobando si el socio ya posee este abono");
			
			while((linea = reader.readLine()) != null) 
			{
				partes = linea.split("-");
				linea = partes[1];
				if(linea.trim().equals(Long.toString(idSocio))) {
					return true;
				}
			}
			reader.close();
			
		}catch(IOException e) {}
		return false;
	}
	
	/**
	 * Da de alta un abono de un tipo y deporte determinados.
	 * @param abono
	 * @param idSocio
	 */
	public void darDeAltaAbono(Abono abono, Long idSocio) {
		
		comprobarDisponibilidadAbono(abono.getDeporteAbono());
		
		File f;
		String nombreFichero = "abonos" + abono.getDeporteAbono() + ".txt"; 
		f= new File(nombreFichero);
		
		try {
			
			if(!f.exists()) 
			{	
				f.createNewFile();
			}

			FileWriter w = new FileWriter(f.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			
			if (comprobarDatosAbono(abono) && !comprobarExistenciaAbono(abono,idSocio)) 
			{
				wr.append(abono.getIdAbono() + "-" + idSocio + "\n");
			}
			else 
			{
				System.out.println("El deporte o el tipo de abono son incorrectos.");
			}
			
			wr.close();
			bw.close();
			generarAbono(abono,idSocio);
			modificarAbonosDisponibles(abono.getDeporteAbono());
		
		}catch (IOException e) {}
	}
	
	/**
	 * Genera un fichero con los datos del abono creado
	 * @param abono
	 * @param idSocio
	 */
	public void generarAbono(Abono abono, Long idSocio) {
		
		File f;
		String nombreFichero = Long.toString(idSocio) + ".txt";
		f= new File(nombreFichero);
		
		try {
			
			if(!f.exists()) 
			{	
				f.createNewFile();
			}
			
			FileWriter w = new FileWriter(f.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			
			wr.append(abono.getIdAbono() + "\n"); 
			wr.append(abono.getDeporteAbono() + "\n");
			wr.append(abono.getTipoAbono() + "\n");
			wr.append(abono.getFechaExpedicionAbono() + "\n");
			wr.append(abono.getLocalidad() + "\n");
			
			wr.close();
			bw.close();

		} catch(IOException e) {}
	}
	
	/**
	 * Resta en uno los abonos disponibles de un deporte en concreto
	 * @param deporte
	 */
	public void modificarAbonosDisponibles(String deporte) {
		File ficheroLectura;
		File ficheroEscritura;
		ficheroLectura = new File(nombreFicheroAbonosDisponibles);
		ficheroEscritura = new File("temporal.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ficheroLectura));
			BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroEscritura));

			String linea;
			String abonosDisponibles;
			int nuevosAbonosDisponibles;
			String[] partes;
			while((linea = reader.readLine()) != null) 
			{
				if(linea.contains(deporte)) 
				{
					partes = linea.split("-");
					abonosDisponibles = partes[1];
					nuevosAbonosDisponibles = Integer.parseInt(abonosDisponibles) - 1;
					linea = deporte + "-" + nuevosAbonosDisponibles;
					writer.write(linea + "\n");
				}
			}
			reader.close();
			writer.close();
			ficheroLectura.delete();
			boolean correcto = ficheroEscritura.renameTo(ficheroLectura);
			if(correcto)
			{
				System.out.println("Se ha renombrado satisfactoriamente el fichero.");
			}
			else
			{
				System.out.println("No se ha renombrado correctamente.");
			}
			
		}catch(IOException e) {}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
