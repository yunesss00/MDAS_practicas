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
import es.uco.mdas.negocio.socio.datos.MiObjectOutputStream;


public class LocalidadAccesoDatosImp implements LocalidadAccesoDatos {

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
	public ObjetoLocalidad buscar(long idObjeto) {
		Properties propiedades = new Properties();
		FileReader ficheroPropiedades = null;
		String nombreFichero = null;
		ObjetoLocalidad datosLocalidad = null;
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
			ObjetoLocalidad localidad = null;
			
			  try {
	            	localidad = (ObjetoLocalidad) datos.readObject();
	            	while(localidad != null) {
	            		if(localidad.getIdLocalidad()== idObjeto) {
	                    	datosLocalidad = localidad;
	                    	break;
	                    }
	            		localidad = (ObjetoLocalidad) datos.readObject();
	            	}
	                
	            }  catch (EOFException e ) {
	                System.out.println("No se ha encontrado a ese socio");
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
