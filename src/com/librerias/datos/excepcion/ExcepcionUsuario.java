package com.librerias.datos.excepcion;

public class ExcepcionUsuario extends Exception {
	/**
	 * @author Jorge Silva Borda
	 */

	public ExcepcionUsuario() {
	}

	public ExcepcionUsuario(String msg) {
		super(msg);
	}

	public ExcepcionUsuario(Throwable causa) {
		super(causa);
	}

	public ExcepcionUsuario(String msg, Throwable causa) {
		super(msg, causa);
	}
}
