package es.uco.mdas.aplicacion;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.negocio.socio.ObjetoAbono;

public class MenuAbono {
	
	
		public static void main(String[] argv) {

			int opcionMenu = 1;
			Scanner opcion;
			while (opcionMenu != 0) {
				 System.out.println("|--------------------------------------------------------------------------|");
				 System.out.println("|\t Bienvenido al Programa Gestor de abonos                 |");
				 System.out.println("|--------------------------------------------------------------------------|");
				 System.out.println("|\t Pulse 0 + Enter  -  Para dar de alta un abono a un socio                    	   |");
				 System.out.println("|\t Pulse 1 + Enter  -  Para dar de baja un abono                        |");
				 System.out.println("|\t Pulse 2 + Enter  -  Para renovar un abono                   |");
                 System.out.println("|\t Pulse 3 + Enter  -  Para salir                        |");
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
                        ObjetoAbono abono = solicitarParametros();
                        
		    		
		    		break;
			    	case 1:
			    		
			    		
			    	break;
			    	case 2:
			    		
			    		
			    	break;
                    case 3:

                    break;
			    	
			    		default:
			    			System.out.println("La opcion escogida no se encuentra en el men�");
			    			System.out.println("Intentelo de nuevo");
			    } 
			}
		}

		
		
}
	