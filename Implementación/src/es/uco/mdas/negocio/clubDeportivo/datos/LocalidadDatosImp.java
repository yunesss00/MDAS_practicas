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

import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;

public class LocalidadDatosImp implements LocalidadDatos {

	private static final String FICHEROPROPIEDADES = "ficheros.properties";
	
	private static final String NOMBREFICHERO = "ficheroLocalidades";
	
	private static final String NOMBREFICHEROAUX = "ficheroAux";
	
	
	@Override
	public boolean insertar(ObjetoLocalidad objeto) {
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
            datos = new ObjectOutputStream(new FileOutputStream(fichero));
            if(datos != null) {
                datos.writeObject(objeto);
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
	public boolean borrar(ObjetoLocalidad objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObjetoLocalidad buscar(long idObjeto) {
		Properties propiedades = new Properties();
		FileReader ficheroPropiedades;
		String nombreFichero = null;
		ObjetoLocalidad datosLocalidad = null;
		
		
		FileInputStream fichero = null;
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
			fichero = new FileInputStream( nombreFichero );
			datos = new ObjectInputStream( fichero );		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(datos!=null) {
			ObjetoLocalidad localidad = null;
			
			try {
				while(true) {
					localidad = (ObjetoLocalidad) datos.readObject();
					
					if(localidad.getIdLocalidad()==idObjeto) {
					 datosLocalidad=localidad;
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
				datos.close();
				fichero.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return datosLocalidad;
	}

	@Override
	public boolean modificar(ObjetoLocalidad objeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
