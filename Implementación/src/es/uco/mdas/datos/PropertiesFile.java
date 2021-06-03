package es.uco.mdas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	private String ficheroAbonosDisponibles;
	private String tiposAbono;
	private String deportesAbono;
	
	public PropertiesFile() {
        Properties prop = new Properties();
        String nombreProperties = "properties.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nombreProperties)));
            prop.load(reader);

            this.ficheroAbonosDisponibles = prop.getProperty("ficheroAbonosDisponibles");
            this.tiposAbono = prop.getProperty("tiposAbono");
            this.deportesAbono = prop.getProperty("deportesAbono");
            
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public String getFicheroAbonosDisponibles() {
		return ficheroAbonosDisponibles;
	}
	
	public String getTiposAbono() {
		return tiposAbono;
	}
	
	public String getDeportesAbono() {
		return deportesAbono;
	}
	
}
