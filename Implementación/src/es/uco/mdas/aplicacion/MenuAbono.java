package es.uco.mdas.aplicacion;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.uco.mdas.negocio.socio.ObjetoAbono;
import es.uco.mdas.sistema.abono.GestionarAbonosImp;

public class MenuAbono {
	

    public void DesplegarMenu() {

        GestionarAbonosImp gestorAbono = new GestionarAbonosImp();
        Long idAbono = null;
        Boolean salir = false;
        ObjetoAbono abono = new ObjetoAbono();

        int opcionMenu = 1;
        Scanner opcion;
        while (!salir) {
             System.out.println("|--------------------------------------------------------------------------|");
             System.out.println("|\t Bienvenido al Programa Gestor de abonos y entradas                     |");
             System.out.println("|--------------------------------------------------------------------------|");
             System.out.println("|        Pulse 0 + Enter  -  Para dar de alta un abono a un socio          |");
             System.out.println("|        Pulse 1 + Enter  -  Para dar de baja un abono                     |");
             System.out.println("|        Pulse 2 + Enter  -  Para renovar un abono                         |");
             System.out.println("|        Pulse 3 + Enter  -  Para buscar un abono                          |");
             System.out.println("|        Pulse 4 + Enter  -  Para vender una entrada                       |");
             System.out.println("|        Pulse 5 + Enter  -  Para volver al menu principal                 |");
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
                    System.out.println("Socio introducido con exito \n");
			        System.out.println(abono.infoAbono());


                
                break;
                case 1:
                    idAbono = solicitarId();
                    abono = gestorAbono.obtenerInformacionAbono(idAbono);
                    abono.infoAbono();
                    gestorAbono.darDeBajaAbono(idAbono);
                    
                break;
                case 2:
                    idAbono = solicitarId();
                    abono = gestorAbono.obtenerInformacionAbono(idAbono);
                    abono.infoAbono();
                    gestorAbono.renovarAbono(idAbono);
                    
                break;
                case 3:
                    idAbono = solicitarId();
                    abono = gestorAbono.obtenerInformacionAbono(idAbono);
                    abono.infoAbono();

                break;
                
                case 4:
                    
                break;
                case 5:
                    salir = true;
                    System.out.println("Volviendo al menu principal ...");
                break;
                
                
                    default:
                        System.out.println("La opcion escogida no se encuentra en el men�");
                        System.out.println("Intentelo de nuevo");
            } 
        }

        String[] argv = null;
		MenuPrincipal.main(argv);


    }

    public long solicitarId() {
    
    String entrada;
    Long idAbono;
    Scanner datosScaner = new Scanner(System.in);
    
    System.out.println("\t Introduzca el ID del abono:");
    
    entrada = datosScaner.nextLine();
    
    idAbono = Long.parseLong(entrada);

    
    return idAbono;

    }

    public static ObjetoAbono solicitarParametros(){
        ObjetoAbono abono = new ObjetoAbono();
        int idSocio;
        String deporte;
        String tipo;
        Scanner datosScaner = new Scanner(System.in);

        System.out.println("\tIntroduzca el identificador del socio:");
        idSocio = datosScaner.nextInt();
        datosScaner.nextLine();
        
        System.out.println("\tIntroduzca el deporte del abono:");
        deporte = datosScaner.nextLine();
        

        System.out.println("\tIntroduzca el tipo de abono:");
        tipo = datosScaner.nextLine();
        
        abono.setTipoAbono(tipo);
        abono.setDeporteAbono(deporte);
        abono.setIdSocio(idSocio);
        abono.setFechaExpedicionAbono();
        abono.setIdAbono(23);
        abono.setLocalidad();


        return abono;
    }


		
}
	