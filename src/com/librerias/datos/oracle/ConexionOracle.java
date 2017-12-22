package com.librerias.datos.oracle;

import com.librerias.datos.Conexion;

public class ConexionOracle extends Conexion{
	private String SID;

	public ConexionOracle(String SERVIDOR, String USUARIO, String PASSWORD, String BASEDATOS) {
		super(SERVIDOR, USUARIO, PASSWORD, BASEDATOS);
	}
	
	public ConexionOracle(String SERVIDOR, String USUARIO, String PASSWORD, String BASEDATOS, String SID) {
		super(SERVIDOR, USUARIO, PASSWORD, BASEDATOS);
		this.setSID(SID);
	}

	/**
	 * @return the sID
	 */
	public String getSID() {
		return SID;
	}

	/**
	 * @param sID the sID to set
	 */
	public void setSID(String sID) {
		SID = sID;
	}

}
