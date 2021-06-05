package es.uco.mdas.negocio.socio.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import es.uco.mdas.datos.PropertiesFile;
import es.uco.mdas.negocio.socio.Abono;

public class AbonoDatosImp implements AbonoDatos{

    private PropertiesFile p = new PropertiesFile();
    private String nombreFicheroAbonosDisponibles;
	private String tiposAbono;
	private String deportesAbono;

    public AbonoDatosImp(){
        nombreFicheroAbonosDisponibles = p.getFicheroAbonosDisponibles();
		tiposAbono = p.getTiposAbono();
		deportesAbono = p.getDeportesAbono();
    }

    @Override
    public boolean insertar(Abono abono) {
        Boolean resultado = true;

        if (comprobarDisponiblidadAbono(abono.getDeporteAbono())) {
            File f;
            String nombreFichero = "abonos" + abono.getDeporteAbono() + ".txt";
            f = new File(nombreFichero);

            try{

                if (!f.exists()) {
                f.createNewFile();
                }
                FileWriter w = new FileWriter(f.getAbsoluteFile(),true);
			    BufferedWriter bw = new BufferedWriter(w);
			    PrintWriter wr = new PrintWriter(bw);

                if (comprobarDatosAbono(abono) && !comprobarExistenciaAbono(abono)) 
			{
				wr.append(abono.getIdAbono() + "-" + abono.getIdSocio() + "\n");
				generarAbono(abono);
				modificarAbonosDisponibles(abono.getDeporteAbono(),"insertar");
			}
			
			wr.close();
			bw.close();

            }catch(IOException e){
                e.printStackTrace();
                resultado = !resultado;
            }
        }
        return resultado;

        
    }

    private void modificarAbonosDisponibles(String deporteAbono, String operacion) {
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
				if(linea.contains(deporteAbono)) 
				{
					partes = linea.split("-");
					abonosDisponibles = partes[1];
					if (operacion == "insertar") 
                    {
                        nuevosAbonosDisponibles = Integer.parseInt(abonosDisponibles) - 1;
                    }
                    else
                    {
                        nuevosAbonosDisponibles = Integer.parseInt(abonosDisponibles) + 1;
                    }
					linea = deporteAbono + "-" + nuevosAbonosDisponibles + "\n";
					writer.write(linea);
				}
			}
			reader.close();
			writer.close();
			ficheroLectura.delete();
            ficheroEscritura.renameTo(ficheroLectura);
			
		}catch(IOException e) {}
    }

    private void generarAbono(Abono abono) {
        File f;
		String nombreFichero = Long.toString(abono.getIdAbono()) + ".txt";
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

    private boolean comprobarExistenciaAbono(Abono abono) {
        File f;
		String nombreFichero = "abonos" + abono.getDeporteAbono() + ".txt"; 
		f= new File(nombreFichero);
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			String[] partes;
			System.out.println("Comprobando si el socio ya posee este abono");
			
			while((linea = reader.readLine()) != null) 
			{
				partes = linea.split("-");
				linea = partes[1];
				if(linea.equals(Long.toString(abono.getIdAbono()))) {
					System.out.println("Este socio ya dispone de un abono de este deporte.");
					reader.close();
                    return true;
				}
			}
			reader.close();
			
		}catch(FileNotFoundException e){
            System.out.println("No existe el fichero" + nombreFichero);
        }catch(IOException e) {}
		return false;
    }

    private boolean comprobarDatosAbono(Abono abono) {
        if (tiposAbono.contains(abono.getTipoAbono()) && 
				deportesAbono.contains(abono.getDeporteAbono())) return true;
		System.out.println("El deporte o el tipo de abono son incorrectos.");
		System.out.println("Los deportes disponibles son: " + deportesAbono + "." );
		System.out.println("Los tipos de abono disponibles son: " + tiposAbono + ".");
		return false;
    }

    private boolean comprobarDisponiblidadAbono(String deporteAbono) {
        String noDisponible = "0";
        File f;
		String nombreFichero = nombreFicheroAbonosDisponibles; 
		f= new File(nombreFichero);
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			System.out.println("Comprobando numero de abonos disponibles");
			String[] partes;
			
			while((linea = reader.readLine()) != null)
			{
				partes = linea.split("-");
				linea = partes[1];
			
				if(partes[0] == deporteAbono && linea.trim().equals(noDisponible))
					reader.close();
                    return false;
			}
			reader.close();
		
		}catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No existe el fichero" + nombreFichero);
        }catch(IOException e) {
            e.printStackTrace();
        }
		return true;
    }



    @Override
    public boolean borrar(Abono abono) {
        Boolean resultado = true;
        String nombreFichero = "abonos" + abono.getDeporteAbono() + ".txt";
        File ficheroLectura = new File(nombreFichero);
        File ficheroEscritura = new File("temporal.txt");
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(ficheroLectura));
			BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroEscritura));
			String linea;
            String[] partes;

            while((linea = reader.readLine()) != null){
                partes = linea.split("-");
                linea = partes[1];
                if(linea.equals(Long.toString(abono.getIdAbono()))) 
                {
                   linea = reader.readLine();
                }
                else
                {
                    writer.write(linea + "\n");
                }
                
            }
            writer.close();
			reader.close();
			ficheroLectura.delete();
            ficheroEscritura.renameTo(ficheroLectura);

        }catch(FileNotFoundException e){
            e.printStackTrace();
            resultado = !resultado;
        }catch(IOException e){
            e.printStackTrace();
            resultado = !resultado;
        }
        
        modificarAbonosDisponibles(abono.getDeporteAbono(), "borrar");
        borrarAbonoSocio(abono);

        return resultado; 
    }

    private void borrarAbonoSocio(Abono abono) {
		String nombreFichero = Long.toString(abono.getIdAbono()) + ".txt";
		File ficheroLectura = new File(nombreFichero);
        File ficheroEscritura = new File("temporal.txt");

   
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ficheroLectura));
			BufferedWriter writer = new BufferedWriter(new FileWriter(ficheroEscritura));
			String linea;

            while((linea = reader.readLine()) != null)
            {
                if (linea.trim().equals(Long.toString(abono.getIdAbono())))
                {
                    linea = reader.readLine();
                    linea = reader.readLine();   
                    linea = reader.readLine();
                }
                else
                {
                    writer.write(linea + "\n");
                }
            }
            writer.close();
			reader.close();
			ficheroLectura.delete();
            ficheroEscritura.renameTo(ficheroLectura);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Abono buscar(Long idAbono) {

        return null;
    }

    @Override
    public boolean modificar(Abono abono) {
        return false;
        // TODO Auto-generated method stub
    }

    
    
}
