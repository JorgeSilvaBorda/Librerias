package com.librerias.utiles.comun;

import java.util.Random;

/**
 * Métodos comunes utilizados ya sea para debug o para tratamiento de
 * información general.
 * 
 * @author Jorge Silva Borda
 */
public class Comunes {

	/**
	 * Convierte arreglo de byte a String.
	 * 
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
	 * 
	 * @param arr {@code Object[]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirArreglo(Object[] arr) {
		for (Object a : arr) {
			System.out.println(a);
		}
	}

	/**
	 * Imprime un array de dos dimensiones.
	 * 
	 * @param matriz {@code Object[][]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirMatriz(Object[][] matriz) {
		for (Object[] a : matriz) {
			imprimirArreglo(a);
		}
	}

	/**
	 * Imprime un array de tres dimensiones.
	 * 
	 * @param cubo {@code Object[][][]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirCubo(Object[][][] cubo) {
		for (Object[][] matriz : cubo) {
			imprimirMatriz(matriz);
		}
	}

	/**
	 * Imprime un array de cuatro.
	 * 
	 * @param hyper {@code Object[][][][]} con el arreglo a imprimir en pantalla.
	 */
	public static void imprimirHiperCubo(Object[][][][] hyper) {
		for (Object[][][] cubo : hyper) {
			imprimirCubo(cubo);
		}
	}

	/**
	 * Convierte una tabla {@link javax.swing.JTable} en un arreglo bidimensional.
	 * La primera fila por defecto del arreglo contiene los encabezados de la tabla.
	 * 
	 * @param tabla {@code JTable} a convertir en arreglo bidimensional.
	 */
	public static void tablaToMatrix(javax.swing.JTable tabla) {
		javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tabla.getModel();
		int filas = tabla.getRowCount();
		int columnas = modelo.getColumnCount();
		String[][] salida = new String[filas + 1][columnas];

		salida[0] = getCabeceraTabla(tabla);

		for (int i = 1; i <= filas; i++) {
			for (int j = 0; j < columnas; j++) {
				salida[i][j] = (String) modelo.getValueAt(i, j);
			}
		}
	}

	/**
	 * Obtiene las cabeceras de un {@link javax.swing.JTable} y las convierte a
	 * {@code String[]}.
	 * 
	 * @param tabla {@link javax.swing.JTable} con los datos.
	 * @return {@code String[]} con las cabeceras almacenadas.
	 */
	public static String[] getCabeceraTabla(javax.swing.JTable tabla) {
		String[] salida = new String[tabla.getColumnCount()];
		for (int i = 0; i < tabla.getColumnCount(); i++) {
			salida[i] = tabla.getColumnName(i);
		}
		return salida;
	}

	/**
	 * Genera un numero aleatorio entre dos valores inclusive.
	 * 
	 * @param minimo {@code int} con el mínimo de la generación.
	 * @param maximo {@code int} con el máximo de la generación
	 * @return {@code int} con el número aleatorio generado.
	 */
	public static int aleatorioEntre(int minimo, int maximo) {
		Random rand = new Random();
		return rand.nextInt((maximo + minimo) + 1) + minimo;
	}

	/**
	 * Genera palabras random (Sólo letras).
	 * 
	 * @param largo {@code int} con el largo deseado de la palabra.
	 * @return {@code String} con la palabra generada.
	 */
	public static String palabraRandom(int largo) {
		char[] separados = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ".toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < largo; i++) {
			builder.append(separados[aleatorioEntre(0, separados.length)]);
		}

		return builder.toString();
	}

	/**
	 * Genera una secuencia de números aleatorio en String
	 * 
	 * @param largo {@code int} con el largo de la cifra
	 * @return {@code String} con la cifra construida.
	 */
	public static String secuenciaNumeros(int largo) {
		char[] numeros = "0123456789".toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < largo; i++) { // Secuencia no debe comenzar con "0" en caso de que se desee generar un
											// numero int
			if (i == 0) {
				builder.append(numeros[aleatorioEntre(1, 9)]);
			} else {
				builder.append(numeros[aleatorioEntre(0, 9)]);
			}
		}
		return builder.toString();
	}

	/**
	 * Genera una secuencia de números aleatoria
	 * 
	 * @param largo {@code int} con el largo de la cifra.
	 * @return {@code int} con la cifra generada.
	 */
	public static int secuenciaNumerosInt(int largo) {
		return Integer.parseInt(secuenciaNumeros(largo));
	}
}
