package com.librerias.cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.librerias.utiles.comun.Comunes;

public class SHA {
	public SHA() {

    }

	public String cifrarSha1(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	public String cifrarSha1_Base64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		byte[] encoded = Base64.getEncoder().encode(digest);
		return new String(encoded);
	}

	public String cifrarSha256_Base64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		byte[] encoded = Base64.getEncoder().encode(digest);
		return new String(encoded);
	}

	public String cifrarSha256(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}

	public String cifrarSha512_Base64(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		byte[] encoded = Base64.getEncoder().encode(digest);
		return new String(encoded);
	}

	public String cifrarSha512(String mensaje) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(mensaje.getBytes());
		byte[] digest = md.digest();
		return Comunes.base64ToString(digest);
	}
}
