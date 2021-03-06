package com.librerias.datos.excepcion;

/**
 * @author Jorge Silva Borda
 */
public class ExcepcionServidor extends Exception {

	private static final long serialVersionUID = -710118499282889356L;

	public ExcepcionServidor() {
	}

	public ExcepcionServidor(String msg) {
		super(msg);
	}

	public ExcepcionServidor(Throwable causa) {
		super(causa);
	}

	public ExcepcionServidor(String msg, Throwable causa) {
		super(msg, causa);
	}
}
