package com.librerias.datos;

import com.librerias.datos.excepcion.ExcepcionPassword;
import com.librerias.datos.excepcion.ExcepcionServidor;
import com.librerias.datos.excepcion.ExcepcionUsuario;

public class Conexion {
	private final String SERVIDOR, USUARIO, PASSWORD, BASEDATOS;
	private int PUERTO;

	/**
	 * Constructor útil tanto para MySql como para SQL Server. No se especifica
	 * puerto en este caso, puesto que se permite que la conexión tome el puerto por
	 * defecto del motor de base de datos. dentro de sus parámetros de
	 * inicialización.
	 * 
	 * @param SERVIDOR
	 *            {@link java.lang.String}. Con el nombre o IP de la máquina de
	 *            destino de la conexión.
	 * @param USUARIO
	 *            {@link java.lang.String}. Con el nombre de usuario de la base de
	 *            datos para conectar.
	 * @param PASSWORD
	 *            {@link java.lang.String}. Contraseña del usuario de la base de
	 *            datos.
	 * @param BASEDATOS
	 *            {@link java.lang.String}. Nombre de la base de datos.
	 */
	public Conexion(String SERVIDOR, String USUARIO, String PASSWORD, String BASEDATOS) {
		this.SERVIDOR = SERVIDOR;
		this.USUARIO = USUARIO;
		this.PASSWORD = PASSWORD;
		this.BASEDATOS = BASEDATOS;
	}

	/**
	 * Constructor útil tanto para MySql como para SQL Server. Dentro de sus
	 * parámetros de inicialización.
	 * 
	 * @param SERVIDOR
	 *            {@link java.lang.String}. Con el nombre o IP de la máquina de
	 *            destino de la conexión.
	 * @param USUARIO
	 *            {@link java.lang.String}. Con el nombre de usuario de la base de
	 *            datos para conectar.
	 * @param PASSWORD
	 *            {@link java.lang.String}. Contraseña del usuario de la base de
	 *            datos.
	 * @param BASEDATOS
	 *            {@link java.lang.String}. Nombre de la base de datos.
	 * @param PUERTO
	 *            {@link Integer}. Puerto de escucha del motor de base de datos.
	 */
	public Conexion(String SERVIDOR, String USUARIO, String PASSWORD, String BASEDATOS, int PUERTO) {
		this.SERVIDOR = SERVIDOR;
		this.USUARIO = USUARIO;
		this.PASSWORD = PASSWORD;
		this.BASEDATOS = BASEDATOS;
		this.PUERTO = PUERTO;
	}

	public int getPUERTO() {
		return PUERTO;
	}

	public void setPUERTO(int pUERTO) {
		PUERTO = pUERTO;
	}

	public String getSERVIDOR() {
		return SERVIDOR;
	}

	public String getUSUARIO() {
		return USUARIO;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public String getBASEDATOS() {
		return BASEDATOS;
	}

	/**
	 * Validador general de parámetros comunes en las conexiones.
	 * 
	 * @return {@link boolean}. {@code true}, en caso de que todos los datos mínimos
	 *         se encuentren presentes. {@code Exception}, en caso de que falte
	 *         algo.
	 * @throws ExcepcionServidor
	 * @throws ExcepcionUsuario
	 * @throws ExcepcionPassword
	 */
	public boolean validar() throws ExcepcionServidor, ExcepcionUsuario, ExcepcionPassword {
		if (SERVIDOR.equals("")) {
			throw new ExcepcionServidor("El nombre del servidor de destino no puede ser vacío.");
		} else if (SERVIDOR == null) {
			throw new ExcepcionServidor("El nombre del servidor de destino no puede ser nulo.",
					new NullPointerException());
		} else if (USUARIO.equals("")) {
			throw new ExcepcionUsuario("El nombre de usuario no puede ser vacío.");
		} else if (USUARIO == null) {
			throw new ExcepcionUsuario("El nombre de usuario no puede ser nulo.", new NullPointerException());
		} else if (PASSWORD.equals("")) {
			throw new ExcepcionPassword("La contraseña no puede ser vacía.");
		} else if (PASSWORD == null) {
			throw new ExcepcionPassword("La contraseña no puede ser nula.", new NullPointerException());
		}
		return true;
	}
}
