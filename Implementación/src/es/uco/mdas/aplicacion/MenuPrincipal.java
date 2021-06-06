package es.uco.mdas.aplicacion;

import java.util.InputMismatchException;
import java.util.Scanner;



public class MenuPrincipal {
	
	
		public static void main(String[] argv) {
			
			MenuSocio menuSocio = new MenuSocio();
			MenuAbono menuAbono = new MenuAbono();
			Boolean cerrar = false;
			int opcionMenu = 1;
			Scanner opcion;
			while (!cerrar) {
				 System.out.println("|--------------------------------------------------------------------------|");
				 System.out.println("|        Bienvenido al Programa Gestor del Club deportivo                  |");
				 System.out.println("|--------------------------------------------------------------------------|");
				 System.out.println("|        Pulse 0 + Enter  -  Para gestionar socios                     	   |");
				 System.out.println("|        Pulse 1 + Enter  -  Para gestionar abonos                         |");
				 System.out.println("|        Pulse 2 + Enter  -  Para salir de la aplicacion                   |");
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
		    		
			    	menuSocio.DesplegarMenu();
		    		
		    		break;
			    	case 1:
			    	
					menuAbono.DesplegarMenu();
			    		
			    	break;
			    	case 2:
						cerrar = true;
			    		System.out.println("Cerrando aplicación ...");
			    		
			    	break;
			    	
			    		default:
			    			System.out.println("La opcion escogida no se encuentra en el men�");
			    			System.out.println("Intentelo de nuevo");
			    } 
			}
		}

		
		
	}
	

