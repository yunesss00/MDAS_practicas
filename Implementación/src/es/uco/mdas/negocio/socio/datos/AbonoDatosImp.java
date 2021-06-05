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

public class AbonoDatosImp implements AbonoDatos{

    /*private PropertiesFile p = new PropertiesFile();
    private String nombreFicheroAbonosDisponibles;
    private String nombreFicheroAbonos;
	private String tiposAbono;
	private String deportesAbono;

    public AbonoDatosImp(){
        nombreFicheroAbonosDisponibles = p.getFicheroAbonosDisponibles();
        nombreFicheroAbonos = p.getFicheroAbonos();
		tiposAbono = p.getTiposAbono();
		deportesAbono = p.getDeportesAbono();
    }*/

    private static final String FICHEROPROPIEDADES = "ficheros.properties";
	private static final String NOMBREFICHERO = "ficheroAbonos";
    private static final String FICHEROTEMPORAL = "temporal.bin";
    //private static final String FICHEROABONOSDISPONIBLES = "abonosDispo";

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
        	datos = new ObjectOutputStream(new FileOutputStream(fichero));
        	if(datos != null) {
        		datos.writeObject(abono);
        		datos.close();
        		ficheroPropiedades.close();	
        	}
        	
        } catch(FileNotFoundException e) {
        	System.out.println("El fichero " + NOMBREFICHERO + "no existe.");
        } catch (IOException e) {
			e.printStackTrace();
		}
        return resultado;
    }

    @Override
    public boolean borrar(Long idSocio) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ObjetoAbono buscar(Long idAbono) {
    	Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        ObjetoAbono datosAbono = null;


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
            fichero = new FileInputStream( nombreFichero );
            contenido = new ObjectInputStream( fichero );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(contenido!=null) {
            ObjetoAbono abono = null;

            try {
                while(true) {
                    abono = (ObjetoAbono) contenido.readObject();

                    if(abono.getIdAbono()==idAbono) {
                     datosAbono=abono;
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
        return datosAbono;
    }

    @Override
    public boolean modificar(ObjetoAbono abono) {
        Properties propiedades = new Properties();
        FileReader ficheroPropiedades;
        String nombreFichero = null;
        Boolean resultado = true;

        File ficheroLectura = null;
		File ficheroEscritura = null;


        try {

            ficheroPropiedades = new FileReader(FICHEROPROPIEDADES);
            propiedades.load(ficheroPropiedades);
            nombreFichero = propiedades.getProperty(NOMBREFICHERO);

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
			
			ficheroEscritura = new File(FICHEROTEMPORAL);
			ficheroDestino = new FileOutputStream (ficheroLectura);
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
					if (abonoAuxiliar.getIdAbono().equals(abono.getIdAbono())) 
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

    










    /*@Override
    public boolean insertar(ObjetoAbono abono) {
        Boolean resultado = true;

        if (comprobarDisponiblidadAbono(abono.getDeporteAbono())) {
            File f;
            f = new File(nombreFicheroAbonos);

            try{

                if (!f.exists()) {
                f.createNewFile();
                }
                FileWriter w = new FileWriter(f.getAbsoluteFile(),true);
			    BufferedWriter bw = new BufferedWriter(w);
			    PrintWriter wr = new PrintWriter(bw);

                if (comprobarDatosAbono(abono) && !comprobarExistenciaAbono(abono)) 
			{
				wr.append(abono.getIdAbono() + "\n");
                wr.append(abono.getIdSocio() + "\n");
                wr.append(abono.getDeporteAbono() + "\n");
			    wr.append(abono.getTipoAbono() + "\n");
			    wr.append(abono.getFechaExpedicionAbono() + "\n");
			    wr.append(abono.getLocalidad() + "\n");
				//generarAbono(abono);
        
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

    

    /*private void generarAbono(Abono abono) {
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

    private boolean comprobarExistenciaAbono(ObjetoAbono abono) {
        File f;
		f= new File(nombreFicheroAbonos);
		
		try {

			BufferedReader reader = new BufferedReader(new FileReader(nombreFicheroAbonos));
			String linea;
			System.out.println("Comprobando si el socio ya posee este abono");
			
			while((linea = reader.readLine()) != null) 
			{
				if(linea.trim().equals(Long.toString(abono.getIdAbono()))) {
					System.out.println("Este socio ya dispone de un abono de este deporte.");
					reader.close();
                    return true;
				}
			}
			reader.close();
			
		}catch(FileNotFoundException e){
            System.out.println("No existe el fichero" + nombreFicheroAbonos);
        }catch(IOException e) {}
		return false;
    }

    private boolean comprobarDatosAbono(ObjetoAbono abono) {
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


    @Override
    public boolean borrar(ObjetoAbono abono) {
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

    private void borrarAbonoSocio(ObjetoAbono abono) {
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
    public ObjetoAbono buscar(Long idAbono) {
        File f;
        ObjetoAbono abono = new ObjetoAbono();
        f = new File(nombreFicheroAbonos);

        try {

            BufferedReader reader = new BufferedReader(new FileReader(nombreFicheroAbonos));
			String linea;
            
            while ((linea = reader.readLine()) != null) 
            {   
                if (linea.trim().equals(Long.toString(idAbono))) 
                {
                    abono.setIdAbono(idAbono);
                    linea = reader.readLine();
                    abono.setIdSocio(Long.parseLong(linea));
                    linea = reader.readLine();
                    abono.setDeporteAbono(linea);
                    linea = reader.readLine();
                    abono.setTipoAbono(linea);
                    linea = reader.readLine();
                    abono.leerFechaExpedicionAbono(linea);
                    linea = reader.readLine();
                    abono.leerLocalidadAbono(linea);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return abono;
    }
    @Override
    public boolean modificar(ObjetoAbono abono) {
        return false;
        // TODO Auto-generated method stub
    }
 */
    
    
}
