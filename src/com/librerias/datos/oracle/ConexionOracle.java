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
	
	public ConexionOracle(String SERVIDOR, String USUARIO, String PASSWORD, String BASEDATOS, String SID, int PUERTO) {
		super(SERVIDOR, USUARIO, PASSWORD, BASEDATOS, PUERTO);
		this.setSID(SID);
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}
}
