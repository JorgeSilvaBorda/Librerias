package com.librerias.datos.excepcion;

/**
 * @author Jorge Silva Borda
 */
public class ExcepcionUsuario extends Exception {
	
	private static final long serialVersionUID = -5397071622367290311L;

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
