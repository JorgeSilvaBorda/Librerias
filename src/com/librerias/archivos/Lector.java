package com.librerias.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lector {

	/**
	 * Lee un archivo.
	 * 
	 * @param path {@code String} la ruta del archivo.
	 * @return {@code File} archivo determinado por su ruta. Devuelve null en caso
	 * de que el archivo no exista.
	 */
	public static File leerArchivo(String path) {
		File archivo = new File(path);
		if (archivo.exists()) {
			return archivo;
		}
		return null;
	}

	/**
	 * Extrae el texto de un archivo.
	 * 
	 * @param archivo {@code File} con el archivo a leer.
	 * @return {@code String} con el texto del archivo leído.
	 */
	@SuppressWarnings("resource")
	public static String getTextoArchivo(File archivo) {
		BufferedReader br;
		FileReader fr;
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			StringBuilder builder = new StringBuilder();
			while ((linea = br.readLine()) != null) {
				builder.append(linea);
				builder.append(System.lineSeparator());
			}
			return builder.toString();
		} catch (Exception e) {
			System.out.println("No se ha podido obtener el texto del archivo." + e);
			return null;
		}
	}
}
