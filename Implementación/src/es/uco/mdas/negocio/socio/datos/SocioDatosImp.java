package es.uco.mdas.negocio.socio.datos;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


public class SocioDatosImp implements SocioDatos{
	
	private static final String FICHEROPROPIEDADES = "ficheros.properties";
	private static final String NOMBREFICHERO = "ficheroSocios";

    @Override
    public boolean insertar(ObjetoSocio socio) {
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
        		datos.writeObject(socio);
        		datos.close();
        		ficheroPropiedades.close();	
        	}
        	
        } catch(FileNotFoundException e) {
        	System.out.println("Hola");
        } catch (IOException e) {
			e.printStackTrace();
		}
        return resultado;
    }

    @Override
    public boolean borrar(Long idSocio) {
        return false;
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public ObjetoSocio buscar(long idSocio) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        ObjetoSocio datosSocio = null;


        FileInputStream fichero = null;
        ObjectInputStream contenido = null;


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
            fichero = new FileInputStream(nombreFichero);
            contenido = new ObjectInputStream(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(contenido!=null) {
            ObjetoSocio socio = null;

            try {
                while(true) {
                    socio = (ObjetoSocio) contenido.readObject();

                    if(socio.getIdSocio()==idSocio) {
                     datosSocio=socio;
                     break;
                    }
                }
            }  catch (EOFException e ) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                contenido.close();
                fichero.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return datosSocio;
    }

    @Override
    public boolean modificar(ObjetoSocio socio) {
        return false;
        // TODO Auto-generated method stub
        
    }
    
}
