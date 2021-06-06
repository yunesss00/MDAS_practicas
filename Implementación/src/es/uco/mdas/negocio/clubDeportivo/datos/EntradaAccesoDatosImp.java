package es.uco.mdas.negocio.clubDeportivo.datos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import es.uco.mdas.negocio.clubDeportivo.ObjetoEntrada;
import es.uco.mdas.negocio.socio.datos.MiObjectOutputStream;

public class EntradaAccesoDatosImp implements EntradaAccesoDatos{
	private static final String FICHEROPROPIEDADES = "ficheros.properties";
	private static final String NOMBREFICHERO = "ficheroEntradas";
	
	@Override
	public boolean insertar(ObjetoEntrada objeto) {
		Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero;
        File fichero;
        boolean resultado = true;
        ObjectOutputStream datos;

        try {
        	ficheroPropiedades = new FileReader(FICHEROPROPIEDADES);
        	propiedades.load(ficheroPropiedades);
        	nombreFichero = propiedades.getProperty(NOMBREFICHERO);
        	
        	fichero = new File(nombreFichero);
        	
        	if(fichero.length() == 0) {
        		datos = new ObjectOutputStream(new FileOutputStream(fichero));
        	}
        	else {
            	datos = new MiObjectOutputStream(new FileOutputStream(fichero,true));
        	}
        	
        	if(datos != null) {
        		datos.writeObject(objeto);
        		datos.close();
        		ficheroPropiedades.close();	
        	}
        	
        } catch(FileNotFoundException e) {
        	 System.out.println("El fichero no se encuentra disponible");
        } catch (IOException e) {
			e.printStackTrace();
		}
        return resultado;
    }

	@Override
	public ObjetoEntrada buscar(long idObjeto) {
		Properties propiedades = new Properties();
		FileReader ficheroPropiedades = null;
		String nombreFichero = null;
		ObjetoEntrada datosEntrada = null;
		File fichero;
		
		FileInputStream ficheroDatos = null;
		ObjectInputStream datos = null;
		
		
		try {
			
			ficheroPropiedades = new FileReader(FICHEROPROPIEDADES);
			propiedades.load(ficheroPropiedades);
			nombreFichero = propiedades.getProperty(NOMBREFICHERO);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		 try {
	            fichero = new File(nombreFichero);
	            ficheroDatos = new FileInputStream(fichero);
	            datos = new ObjectInputStream(ficheroDatos);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		if(datos!=null) {
			ObjetoEntrada entrada = null;
			
			  try {
	            	entrada = (ObjetoEntrada) datos.readObject();
	            	while(entrada != null) {
	            		if(entrada.getIdEntrada()== idObjeto) {
	                    	datosEntrada = entrada;
	                    	break;
	                    }
	            		entrada = (ObjetoEntrada) datos.readObject();
	            	}
	                
	            }  catch (EOFException e ) {
	                System.out.println("No se ha encontrado esa entrada");
	            }catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            try {
	                datos.close();
	                ficheroDatos.close();
	                ficheroPropiedades.close();
	            }catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return datosEntrada;
	    }

}
