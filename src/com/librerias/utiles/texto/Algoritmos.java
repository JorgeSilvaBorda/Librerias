package com.librerias.utiles.texto;

/**
 * Algoritmos de tratamiento de texto
 * @author Jorge Silva Borda
 *
 */
public class Algoritmos {
	
	/**
	 * Arroja el valor de acuerdo a la semejanza de las palabras que se están comparando.
	 * 0, si las palabras son iguales.
	 * n, donde n = distancia Levenshtein (Cantidad de cambios que se deben aplicar a la cadena original para convertirla en la segunda).
	 * @param str1 {@code String}. La cadena original que se desea evaluar.
	 * @param str2 {@code String}. La cadena en la que se desea convertir la original y evaluar.
	 * @return {@code int}. El resultado de la comparación.
	 */
	public static int levenshtein(String str1, String str2) {
		return distanciaLevenshtein(str1.toCharArray(), str2.toCharArray());
	}
	
	private static int minimo(int a, int b, int c) {
		return Math.min(a,  Math.min(b,  c));
	}
	
	private static int distanciaLevenshtein(char[] str1, char[] str2) {
		int[][] distancia = new int[str1.length + 1][str2.length +1];
		for(int i = 0; i <= str1.length; i++) {
			distancia[i][0] = i;
		}
		for(int j = 0; j <= str2.length; j++) {
			distancia[0][j] = j;
		}
		for(int i = 1; i<= str1.length; i++) {
			for(int j = 1; j<= str2.length; j++) {
				distancia[i][j] = minimo(distancia[i - 1][j] + 1, distancia[i][j - 1] + 1, distancia[i - 1][j - 1] + (str1[i - 1] == str2[j - 1]? 0 : 1));
			}
		}
		return distancia[str1.length][str2.length];
	}
}