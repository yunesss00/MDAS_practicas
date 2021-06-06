package es.uco.mdas.aplicacion;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.negocio.clubDeportivo.ObjetoEntrada;
import es.uco.mdas.negocio.clubDeportivo.ObjetoLocalidad;
import es.uco.mdas.negocio.socio.ObjetoAbono;
import es.uco.mdas.sistema.abono.GestionarAbonosImp;
import es.uco.mdas.sistema.localidad.ComprobarDisponibilidadLocalidad;
import es.uco.mdas.sistema.localidad.ComprobarDisponibilidadLocalidadImp;
import es.uco.mdas.sistema.localidad.VenderEntradaImp;

public class MenuAbono {
	

    public void DesplegarMenu() {

        GestionarAbonosImp gestorAbono = new GestionarAbonosImp();
        ComprobarDisponibilidadLocalidadImp gestorLocalidad = new ComprobarDisponibilidadLocalidadImp();
        VenderEntradaImp gestorEntrada = new VenderEntradaImp();
        Long idAbono = null;
        Long idLocalidad = null;
        Boolean salir = false;
        ObjetoAbono abono = new ObjetoAbono();
        ObjetoEntrada entrada = new ObjetoEntrada();

        int opcionMenu = 1;
        Scanner opcion;
        while (!salir) {
             System.out.println("|--------------------------------------------------------------------------|");
             System.out.println("|        Bienvenido al Programa Gestor de abonos y entradas                |");
             System.out.println("|--------------------------------------------------------------------------|");
             System.out.println("|        Pulse 0 + Enter  -  Para dar de alta un abono a un socio          |");
             System.out.println("|        Pulse 1 + Enter  -  Para dar de baja un abono                     |");
             System.out.println("|        Pulse 2 + Enter  -  Para renovar un abono                         |");
             System.out.println("|        Pulse 3 + Enter  -  Para buscar un abono                          |");
             System.out.println("|        Pulse 4 + Enter  -  Para vender una entrada                       |");
             System.out.println("|        Pulse 4 + Enter  -  Para volver al menu principal                 |");
             System.out.println("|--------------------------------------------------------------------------|");
            
            try {
                opcion = new Scanner(System.in);
                opcionMenu = opcion.nextInt();
            }
            catch (InputMismatchException e) 
            {
                opcionMenu = 0;
                System.out.println("El valor introducido es incorrecto intentelo de nuevo");
            }
            
            switch (opcionMenu) {
                case 0: 
                    abono = solicitarParametros();
                    gestorAbono.darDeAltaAbono(abono);
                    System.out.println("Abono introducido con exito\n");
			        System.out.println(abono.infoAbono());


                
                break;
                case 1:
                    idAbono = solicitarIdAbono();
                    abono = gestorAbono.obtenerInformacionAbono(idAbono);
                    if(abono != null) {
                    	System.out.println(abono.infoAbono());
                    	if(!gestorAbono.darDeBajaAbono(idAbono)) {
                    		System.out.println("Se ha dado de baja el abono con exito");
                    	}
                    	else {
                    		System.out.println("No se ha podido dar de baja el abono");
                    	}
                    }
                    
                    
                break;
                case 2:
                    idAbono = solicitarIdAbono();
                    abono = gestorAbono.obtenerInformacionAbono(idAbono);
                    if(abono != null) {
                    	System.out.println(abono.infoAbono());
                        gestorAbono.renovarAbono(idAbono);
                    }
                    
                    
                break;
                case 3:
                	idAbono = solicitarIdAbono();
                    abono = gestorAbono.obtenerInformacionAbono(idAbono);
                    if(abono != null) {
                    	System.out.println(abono.infoAbono());
                    }
                    
                   
                       	
                 break;
                case 4:
                   idLocalidad = solicitarIdLocalidad();
                 /*  if ((gestorLocalidad.comprobarReservaLocalidad(idLocalidad) == true)){
   		    		System.out.println("Esta localidad esta reservada");
                   }
                   else {*/
                	   entrada =  solicitarDatosEntrada(idLocalidad);
                	 // gestorEntrada.actualizarLocalidad(idLocalidad);
                	   gestorEntrada.setDatosEntrada(entrada);
                	   System.out.println("Entrada procesada con exito \n");
       			       System.out.println(entrada.infoEntrada());
                   
                   
                	
                break;
                
                case 5:
                    salir = true;
                    System.out.println("Volviendo al menu principal ...");
                break;
                
                
                
                    default:
                        System.out.println("La opcion escogida no se encuentra en el menu");
                        System.out.println("Intentelo de nuevo");
            } 
        }

        String[] argv = null;
		MenuPrincipal.main(argv);


    }

    public long solicitarIdAbono() {
    
    long idAbono;
    Scanner datosScaner = new Scanner(System.in);
    
    System.out.println("\t Introduzca el ID del abono:");
    
    idAbono = datosScaner.nextLong();
    
    
    
    return idAbono;

    }
    
    public long solicitarIdLocalidad() {
        
        long idLocalidad;
        Scanner datosScaner = new Scanner(System.in);
        
        System.out.println("\t Introduzca el ID de la localidad donde desea comprar la entrada:");
        
        idLocalidad = datosScaner.nextLong();
        
      
        
        return idLocalidad;

        }

    public static ObjetoAbono solicitarParametros(){
        ObjetoAbono abono = null;
        Long idSocio;
        String deporte;
        String tipo;
        Scanner datosScaner = new Scanner(System.in);

        System.out.println("\tIntroduzca el identificador del socio:");
        idSocio = datosScaner.nextLong();
        
        
        datosScaner.nextLine();
        System.out.println("\tIntroduzca el deporte del abono:");
        deporte = datosScaner.nextLine();
        

        System.out.println("\tIntroduzca el tipo de abono:");
        tipo = datosScaner.nextLine();
        
        abono = new ObjetoAbono(deporte, tipo, idSocio);
        
        return abono;
    }

    public ObjetoEntrada solicitarDatosEntrada(long idLocalidad) {

    	 ObjetoEntrada entrada = new ObjetoEntrada();
    	 String fecha = null;
    	 Date fechaPartido = null;  
    	 String horaPartido;
    	 String comprador;
    	 float precio;
         Scanner datosScaner = new Scanner(System.in);
      

         System.out.println("\t Introduzca su fecha del partido  -  formato : dd/MM/yyyy ");
         fecha = datosScaner.nextLine();
     
			
			try {
				fechaPartido = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
				
			} catch (ParseException e) {
			    System.out.println("\t El fomato de la fecha de nacimiento es: dd/MM/yyyy");
				e.printStackTrace();
			}
         
         System.out.println("\tIntroduzca la hora del partido: 00:00-24:00");
         horaPartido = datosScaner.nextLine();
         

         System.out.println("\tIntroduzca el nombre del comprador:");
         comprador = datosScaner.nextLine();
         
         System.out.println("\tIntroduzca el precio de la entrada:");
         precio = datosScaner.nextFloat();
         
         entrada.setIdLocalidad(idLocalidad);
         entrada.setFechaPartido(fechaPartido);
         entrada.setHoraPartido(horaPartido);
         entrada.setComprador(comprador);
         entrada.setPrecio(precio);
       


         return entrada;
    	
    }
}