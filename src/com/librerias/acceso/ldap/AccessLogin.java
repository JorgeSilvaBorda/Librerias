package com.librerias.acceso.ldap;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 * Interfaz para realizar login a través de LDAP El funcionamiento implica
 * instanciar un objeto de la clase AccesLogin, para luego llamar al método
 * "login" de la misma clase. Ejemplo: AccessLogin access = new AccessLogin();
 * access.login("usuario", "password");
 * 
 * @version 1.0.2
 * @author Jorge Silva Borda 
 * Fecha: 2017-12-13
 */
public class AccessLogin {

	private String maquina; // Nombre de máquina del dominio en donde se aloja LDAP
	private String metodo = "simple";
	private String dominio; // Dominio al cual se realiza login
	private String puerto = "389";
	private String ldapURL; // URL LDAP

	// Métodos de la clase-----------------------------------------------------------------------------------------------------------
	/**
	 * Método a través del que se realiza el login. Requiere de la instanciación de
	 * un objeto de la clase AccessLogin para luego llamar al método con sus
	 * parámetros.
	 * 
	 * @param usuario
	 *            {@code String} con el nombre de usuario.
	 * @param password
	 *            {@code String} con la password del usuario.
	 * @return {@code Boolean}. {@code true} en caso de login exitoso. {@code false}
	 *         en caso de login incorrecto.
	 */
	public boolean login(String usuario, String password) {
		if (usuario != "" && usuario != null && password != "" && password != null && validarProceso()) {
			this.ldapURL = "ldap://" + maquina + "." + dominio + ":" + puerto + "";
			Hashtable<String, String> entorno = new Hashtable<String, String>();
			entorno.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory"); // Clase que realiza la autenticación.
			entorno.put(Context.PROVIDER_URL, ldapURL);
			entorno.put(Context.SECURITY_AUTHENTICATION, metodo); // Método simple de autenticación.
			entorno.put(Context.SECURITY_PRINCIPAL, usuario + "@" + dominio);
			entorno.put(Context.SECURITY_CREDENTIALS, password);
			try {
				DirContext authContext = new InitialDirContext(entorno);
				System.out.println(authContext);
				return true;
			} catch (NamingException ex) {
				return false;
			}
		}
		return false;
	}

	// Métodos del objeto-----------------------------------------------------------------------------------------------------------

	/**
	 * Constructor completo
	 */
	public AccessLogin(String maquina, String metodo, String dominio, String puerto, String ldapURL) {
		super();
		this.maquina = maquina;
		this.metodo = metodo;
		this.dominio = dominio;
		this.puerto = puerto;
		this.ldapURL = ldapURL;
	}

	public boolean validarProceso() {
		return this.maquina != "" && this.maquina != null && this.metodo != null && this.metodo != "" && this.dominio != "" && this.dominio != null && this.puerto != null && this.puerto != "";
	}

	/**
	 * Constructor vacío
	 */
	public AccessLogin() {
		
	}

	/**
	 * @return {@code String} con el nombre de la máquina que aloja LDAP
	 */
	public String getMaquina() {
		return maquina;
	}

	/**
	 * Establece el nombre de la máquina que aloja LDAP.
	 * @param maquina {@code String} con el nombre que se desea asignar a la máquina LDAP
	 */
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	/**
	 * @return {@code String} con el nombre del método de login. Por defecto el método es "Simple"
	 * @see javax.naming.Context
	 */
	public String getMetodo() {
		return metodo;
	}

	/**
	 * Establece el método por el cual se debe realizar el login. Por defecto el
	 * método se encuentra establecido como "Simple"
	 * @param metodo {@code String} con el nombre del método a establecer.
	 * @see javax.naming.Context
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	/**
	 * @return {@code String} con el nombre del dominio al que se debe autenticar.
	 */
	public String getDominio() {
		return dominio;
	}

	/**
	 * Establece el nombre del dominio contra el que se debe autenticar. Por defecto
	 * @param dominio {@code String} con el nombre del dominio.
	 */
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	/**
	 * @return {@code String} con el puerto de conexión a LDAP.
	 */
	public String getPuerto() {
		return puerto;
	}

	/**
	 * Establece el puerto de comunicación a LDAP. Por defecto el puerto es 389.
	 * @param puerto {@code String} con el número de puerto para la URL de LDAP.
	 */
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
}