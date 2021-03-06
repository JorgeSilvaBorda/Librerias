package com.librerias.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.librerias.utiles.comun.Comunes;

public class MD5 {

	/**
	 * Cifra un mensaje en algoritmo MD5
	 * 
	 * @param mensaje {@link java.lang.String} con el mensaje a cifrar.
	 * @return {@link java.lang.String} con el mensaje cifrado en MD5.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrar(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	/**
	 * Cifra un mensaje en algoritmo MD5
	 * @param mensaje {@link java.lang.String} con el mensaje a cifrar.
	 * @return {@link java.lang.String} con el mensaje cifrado en MD5 base64.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarBase64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		byte[] encoded = Base64.getEncoder().encode(digest);
		return new String(encoded);
	}
}