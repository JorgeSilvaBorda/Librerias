package com.librerias.datos.excepcion;

/**
 * @author Jorge Silva Borda
 */
public class ExcepcionPassword extends Exception {

	private static final long serialVersionUID = 8759883988598433949L;

	public ExcepcionPassword() {
    }

    public ExcepcionPassword(String msg) {
        super(msg);
    }

    public ExcepcionPassword(Throwable causa) {
        super(causa);
    }

    public ExcepcionPassword(String msg, Throwable causa) {
        super(msg, causa);
    }
}

