package com.librerias.archivos;

import java.io.File;

public class Archivos {
	
	public static File getArchivo(String path) {
		return Lector.leerArchivo(path);
	}
	
	public static String getTextoArchivo(File archivo) {
		return Lector.getTextoArchivo(archivo);
	}
}
