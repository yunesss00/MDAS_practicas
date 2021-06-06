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
	
	private static final String FICHEROTEMPORAL = "ficheroAuxiliar";
	
	
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
		Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        String nombreFicheroAuxiliar = null;
        Boolean resultado = true;

        File ficheroLectura = null;
		File ficheroEscritura = null;


        try {

            ficheroPropiedades = new FileReader(FICHEROPROPIEDADES);
            propiedades.load(ficheroPropiedades);
            nombreFichero = propiedades.getProperty(NOMBREFICHERO);
            nombreFicheroAuxiliar = propiedades.getProperty(FICHEROTEMPORAL);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }      
        
        if (nombreFichero == null) return false;
        
        FileInputStream ficheroOrigen = null;
		ObjectInputStream contenidoLectura = null;
		
		FileOutputStream ficheroDestino = null;
		ObjectOutputStream contenidoEscritura = null;
		
		try {
			
			ficheroLectura = new File(nombreFichero);
			ficheroOrigen = new FileInputStream (ficheroEscritura);
			contenidoLectura= new ObjectInputStream (ficheroOrigen);
			
			ficheroEscritura = new File(nombreFicheroAuxiliar);
			ficheroDestino = new FileOutputStream (ficheroLectura);
			contenidoEscritura= new ObjectOutputStream (ficheroDestino);
				
			
			
		} catch (FileNotFoundException e) {

			System.out.println("El fichero de " + nombreFichero + " no existe");
			return resultado;
		} catch (IOException e) {
			
			e.printStackTrace();
		}

        if (contenidoLectura != null && contenidoEscritura != null) {
			ObjetoLocalidad LocalidadAuxiliar = null;
			
			try {
				while (true)
                 {
					LocalidadAuxiliar = (ObjetoLocalidad) contenidoLectura.readObject() ;
					if (LocalidadAuxiliar.getIdLocalidad() == (objeto.getIdLocalidad())) 
                    {
						LocalidadAuxiliar = objeto;
						resultado = !resultado;
					}
					contenidoEscritura.writeObject(LocalidadAuxiliar);
						
				}
			} catch (EOFException e) {
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
			try {
				contenidoLectura.close();
				ficheroOrigen.close();
				contenidoEscritura.close();
				ficheroDestino.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			ficheroLectura.delete();
		    ficheroEscritura.renameTo(ficheroLectura);
			
		}


        
        return resultado;
    }

}
