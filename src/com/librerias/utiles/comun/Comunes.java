package com.librerias.utiles.comun;

public class Comunes {
	
	public String base64ToString(byte[] bytes) {
		StringBuilder str = new StringBuilder();
		for (byte b : bytes) {
			str.append(Integer.toHexString(0xFF & b));
		}
		return str.toString();
	}
}