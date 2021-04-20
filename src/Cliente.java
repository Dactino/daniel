import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Logger;

public class Cliente {
	 Logger log = Logger.getLogger(Cliente.class.getName());
	transient String nombre;
	String identificador;

	Cliente() { 

		this.nombre = "";
		this.identificador = "";
	}

	Cliente(String nombreArchivo) {

		final File archivo = new File(nombreArchivo);
		try {
			Scanner leer = new Scanner(archivo);
			this.nombre = leer.nextLine();
			this.identificador = leer.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void guardar() {

		try {
			final File carpeta = new File("Clientes");
			if (carpeta.exists() == false) {
				carpeta.mkdir();
			}
			BufferedWriter wr = Files.newBufferedWriter("Clientes\\" + this.id + ".txt");
			wr.write(this.nombre + "\r\n" + this.id);
			wr.flush();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void info() {
		log.fine("");
		log.fine("———————————————————————————————————————————————");
		log.fine("Nombre del cliente: "+this.nombre);
		log.fine("Identificador del cliente: "+this.id);
		log.fine("———————————————————————————————————————————————");
		log.fine("");
		System.out.println("Hola Muundo");
	}
	
	
}
