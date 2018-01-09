package com.librerias.utiles.comun;

/**
 * Métodos comunes utilizados ya sea para debug o para tratamiento de información general.
 * @author Jorge Silva Borda
 */
public class Comunes {
	
	/**
	 * Convierte arreglo de byte a String.
	 * @param bytes {@code byte[]}. Con la secuencia a convertir y codificar.
	 * @return {@code String}, con la secuencia codificada.
	 */
	public static String base64ToString(byte[] bytes) {
		StringBuilder str = new StringBuilder();
		for (byte b : bytes) {
			str.append(Integer.toHexString(0xFF & b));
		}
		return str.toString();
	}
	
	/**
	 * Imprime un array.
	 * @param arr {@code Object[]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirArreglo(Object[] arr) {
		for(Object a : arr) {
			System.out.println(a);
		}
	}
	
	/**
	 * Imprime un array de dos dimensiones.
	 * @param matriz {@code Object[][]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirMatriz(Object[][] matriz) {
		for(Object[] a : matriz) {
			imprimirArreglo(a);
		}
	}
	
	/**
	 * Imprime un array de tres dimensiones.
	 * @param cubo {@code Object[][][]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirCubo(Object[][][] cubo) {
		for(Object[][] matriz : cubo) {
			imprimirMatriz(matriz);
		}
	}
	
	/**
	 * Imprime un array de cuatro.
	 * @param hyper {@code Object[][][][]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirHiperCubo(Object[][][][] hyper) {
		for(Object[][][] cubo : hyper) {
			imprimirCubo(cubo);
		}
	}
}

