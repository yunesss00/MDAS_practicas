package es.uco.mdas.negocio.socio.datos;

import es.uco.mdas.negocio.socio.ObjetoAbono;
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
	private static final String FICHEROTEMPORAL = "ficheroAuxiliar";

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
        	 System.out.println("El fichero no se encuentra disponible");
        } catch (IOException e) {
			e.printStackTrace();
		}
        return resultado;
    }

    @Override
    public boolean borrar(Long idSocio) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        Boolean resultado = false;
        String nombreFicheroAuxiliar = null;
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
			ficheroOrigen = new FileInputStream (ficheroLectura);
			contenidoLectura= new ObjectInputStream (ficheroOrigen);
			
			ficheroEscritura = new File(nombreFicheroAuxiliar);
			ficheroDestino = new FileOutputStream (ficheroEscritura);
			contenidoEscritura= new ObjectOutputStream (ficheroDestino);
				
			
			
		} catch (FileNotFoundException e) {

			System.out.println("El fichero de " + nombreFichero + " no existe");
			return resultado;
		} catch (IOException e) {
			
			e.printStackTrace();
		}

        if (contenidoLectura != null && contenidoEscritura != null) {
			ObjetoSocio socioAuxiliar = null;
			
			try {
				while (true)
                 {
					socioAuxiliar = (ObjetoSocio) contenidoLectura.readObject() ;
					if (!socioAuxiliar.getIdSocio().equals(idSocio)) {
						contenidoEscritura.writeObject(socioAuxiliar);
					}	
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
    
    @Override
    public ObjetoSocio buscar(Long idSocio) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades = null;
        String nombreFichero = null;
        ObjetoSocio datosSocio = null;
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
            ObjetoSocio socio = null;

            try {
            	socio = (ObjetoSocio) datos.readObject();
            	while(socio != null) {
            		if(socio.getIdSocio().equals(idSocio)) {
                    	datosSocio = socio;
                    	break;
                    }
            		socio = (ObjetoSocio) datos.readObject();
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
        return datosSocio;
    }

    @Override
    public boolean modificar(ObjetoSocio socio) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        Boolean resultado = false;
        String nombreFicheroAuxiliar = null;
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
			ficheroOrigen = new FileInputStream (ficheroLectura);
			contenidoLectura= new ObjectInputStream (ficheroOrigen);
			
			ficheroEscritura = new File(nombreFicheroAuxiliar);
			ficheroDestino = new FileOutputStream (ficheroEscritura);
			contenidoEscritura= new ObjectOutputStream (ficheroDestino);
				
			
			
		} catch (FileNotFoundException e) {

			System.out.println("El fichero de " + nombreFichero + " no existe");
			return resultado;
		} catch (IOException e) {
			
			e.printStackTrace();
		}

        if (contenidoLectura != null && contenidoEscritura != null) {
			ObjetoSocio socioAuxiliar = null;
			
			try {
				while (true)
                 {
					socioAuxiliar = (ObjetoSocio) contenidoLectura.readObject() ;
					if (socioAuxiliar.getIdSocio().equals(socio.getIdSocio())) 
                    {
						socioAuxiliar = socio;
						resultado = !resultado;
					}
					contenidoEscritura.writeObject(socioAuxiliar);
						
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
