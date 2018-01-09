package com.librerias.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.librerias.utiles.comun.Comunes;

/**
 * Cifrados SHA1, SHA256, SHA512
 * @author Jorge SIlva Borda
 */
public class SHA {

	/**
	 * Cifra un mensaje a SHA-1 y lo devuelve como {@code String}.
	 * @param mensaje {@code String} con el mensaje a codificar.
	 * @return {@code String} con el mensaje codificado.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarSha1(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	/**
	 * Cifra un mensaje a SHA-1 y lo devuelve como {@code String} en base64.
	 * @param mensaje {@code String} con el mensaje a codificar.
	 * @return {@code String} con el mensaje codificado.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarSha1_Base64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		byte[] encoded = Base64.getEncoder().encode(digest);
		return new String(encoded);
	}

	/**
	 * Cifra un mensaje a SHA-256 y lo devuelve como {@code String}.
	 * @param mensaje {@code String} con el mensaje a codificar.
	 * @return {@code String} con el mensaje codificado.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarSha256(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	/**
	 * Cifra un mensaje a SHA-256 y lo devuelve como {@code String} en base64.
	 * @param mensaje {@code String} con el mensaje a codificar.
	 * @return {@code String} con el mensaje codificado.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarSha256_Base64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	/**
	 * Cifra un mensaje a SHA-512 y lo devuelve como {@code String}.
	 * @param mensaje {@code String} con el mensaje a codificar.
	 * @return {@code String} con el mensaje codificado.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarSha512(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	/**
	 * Cifra un mensaje a SHA-512 y lo devuelve como {@code String} en base64.
	 * @param mensaje {@code String} con el mensaje a codificar.
	 * @return {@code String} con el mensaje codificado.
	 * @throws NoSuchAlgorithmException
	 */
	public static String cifrarSha512_Base64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}
}