package es.uco.mdas.negocio.socio.datos;

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

import es.uco.mdas.negocio.socio.ObjetoAbono;

public class AbonoAccesoDatosImp implements AbonoAccesoDatos{
    private static final String FICHEROPROPIEDADES = "ficheros.properties";
	private static final String NOMBREFICHERO = "ficheroAbonos";
    private static final String FICHEROTEMPORAL = "ficheroAuxiliar";

    @Override
    public boolean insertar(ObjetoAbono abono) {
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
        		datos.writeObject(abono);
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
    public ObjetoAbono buscar(Long idAbono) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades = null;
        String nombreFichero = null;
        ObjetoAbono datosAbono = null;
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
            ObjetoAbono abono = null;

            try {
            	abono = (ObjetoAbono) datos.readObject();
            	while(abono != null) {
            		if(abono.getIdAbono().equals(idAbono)) {
                    	datosAbono = abono;
                    	break;
                    }
            		abono = (ObjetoAbono) datos.readObject();
            	}
                
            }  catch (EOFException e ) {
                System.out.println("No se ha encontrado ese abono");
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
        return datosAbono;
    }

    @Override
    public boolean modificar(ObjetoAbono abono) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        Boolean resultado = true;
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
			ObjetoAbono abonoAuxiliar = null;
			
			try {
				while (true)
                 {
					abonoAuxiliar = (ObjetoAbono) contenidoLectura.readObject() ;
					if (abonoAuxiliar.getIdSocio().equals(abono.getIdAbono())) 
                    {
						abonoAuxiliar = abono;
						resultado = !resultado;
					}
					contenidoEscritura.writeObject(abonoAuxiliar);
						
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
    public boolean borrar(Long idAbono) {
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
			ObjetoAbono abonoAuxiliar = null;
			
			try {
				while (true)
                 {
					abonoAuxiliar = (ObjetoAbono) contenidoLectura.readObject() ;
					if (!abonoAuxiliar.getIdAbono().equals(idAbono)) {
						contenidoEscritura.writeObject(abonoAuxiliar);
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
     
}
