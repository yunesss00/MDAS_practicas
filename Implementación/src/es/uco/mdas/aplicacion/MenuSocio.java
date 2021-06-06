package es.uco.mdas.aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.negocio.socio.ObjetoSocio;
import es.uco.mdas.negocio.socio.SocioMgtImp;
import es.uco.mdas.negocio.socio.TipoCarnet;
import es.uco.mdas.negocio.socio.datos.SocioDatosImp;
import es.uco.mdas.sistema.socio.BuscarSocio;
import es.uco.mdas.sistema.socio.BuscarSocioImp;
import es.uco.mdas.sistema.socio.RegistrarSocio;
import es.uco.mdas.sistema.socio.RegistrarSocioImp;

public class MenuSocio {
	
	public void DesplegarMenu(){
		
		int opcionMenu = 1;
		Scanner opcion;
		BuscarSocio busquedaSocio = new BuscarSocioImp();
		RegistrarSocio registroSocio = new RegistrarSocioImp();
		
		while (opcionMenu != 0) {
		 System.out.println("|----------------------------------------------------------------|");
		 System.out.println("|            Bienvenido al GESTOR DE SOCIOS                      |");
		 System.out.println("|----------------------------------------------------------------|");
		 System.out.println("|        Pulse 0 + Enter  -  Para añadir un nuevo socio          |");
		 System.out.println("|        Pulse 1 + Enter  -  Para buscar un socio                |");
		 System.out.println("|        Pulse 2 + Enter  -  Para modificar un socio             |");
		 System.out.println("|        Pulse 3 + Enter  -  Para eliminar un socio              |");
		 System.out.println("|        Pulse 4 + Enter  -  Para salir del gestor de socios     |");
		 System.out.println("|----------------------------------------------------------------|");
		 
		 
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
	    		
		    	ObjetoSocio nuevoSocio = solicitarDatos();
			    registroSocio.setDatosSocio(nuevoSocio);
			    System.out.println(nuevoSocio.mostrarDatosSocio());
	    		
	    		break;
		    	case 1:
		    	
		    
		    	long idBuscar = solicitarId();
		    	busquedaSocio.mostrarDatosSocio(idBuscar);
		    		
		    	break;
		    	case 2:
		    	
		    	long idModificar = solicitarId();
			    busquedaSocio.mostrarDatosSocio(idModificar);
		    		
		    	break;
		    	case 3:
		    	
		    	long idEliminar = solicitarId();
				busquedaSocio.mostrarDatosSocio(idEliminar);
		    		
			    	break;
		    	case 4:
		    		
		    		
			    	break;
		    	
		    		default:
		    			System.out.println("La opcion escogida no se encuentra en el menú");
		    			System.out.println("Intentelo de nuevo");
		    } 
		}
	}

	
	public ObjetoSocio solicitarDatos() {
		
		 String nombreSocio;
		 String apellidosSocio;
		 String fechaNacimiento = null;
		 Date fechaNacimientoSocio = null;
		 int verificarTelefono = 0;
		
		
		 Scanner datosScaner = new Scanner(System.in);
		
		 
		 System.out.println("\t Introduzca el nombre ");
			
			nombreSocio = datosScaner.nextLine();
			System.out.println("\t Introduzca los apellidos");
			
			apellidosSocio = datosScaner.nextLine();
		
			
			System.out.println("\t Introduzca su fecha de nacimiento formato : dd/MM/yyyy ");
			
			fechaNacimiento = datosScaner.nextLine();
			
			try {
				fechaNacimientoSocio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
				
			} catch (ParseException e) {
			    System.out.println("\t El fomato de la fecha de nacimiento es: dd/MM/yyyy");
				e.printStackTrace();
			}
	
		datosScaner.close();
		ObjetoSocio socio = new ObjetoSocio(nombreSocio,apellidosSocio,fechaNacimientoSocio);
		return socio;
		
		
	}

	public long solicitarId() {
		
		long idSocio;
		Scanner datosScaner = new Scanner(System.in);
		
		System.out.println("\t Introduzca la ID del socio que desea buscar ");
		
		idSocio = datosScaner.nextLong();
		
		datosScaner.close();
		
		return idSocio;
		
		
	}
}