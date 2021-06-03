package es.uco.mdas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	private String ficheroAbonosDisponibles;
	
	public PropertiesFile() {
        Properties prop = new Properties();
        String nombreProperties = "properties.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nombreProperties)));
            prop.load(reader);

            this.ficheroAbonosDisponibles = prop.getProperty("ficheroAbonosDisponibles");
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public String getFicheroAbonosDisponibles() {
		return ficheroAbonosDisponibles;
	}
	
}
