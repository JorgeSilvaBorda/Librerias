package com.librerias.utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Librería destinada a obtener los indicadores económicos chilenos.
 * Algunos de los incluidos son:
 * -UF.
 * -UTM.
 * -DOLAR.
 * WebService consultado desde http://mindicador.cl/
 * @author Jorge Silva Borda
 */
public class Indicadores {
    public static final String SEP = System.getProperty("line.separator");
    public static final String RUTA = "http://www.mindicador.cl/api/";
    
    /**
     * Función que retorna arreglo JSON con todos los indicadores actuales.
     * Los indicadores disponibles son:
     * [uf, ivp, dolar, dolar_intercambio, euro, ipc, utm, imacec, tpm, libra_cobre, tasa_desempleo].
     * Los rangos de fecha de los valores son los siguientes:
     * Unidad de fomento (UF):	Valores desde 1977 hasta hoy.
     * Libra de Cobre:	Valores desde 2012 hasta hoy.
     * Tasa de desempleo:	Valores desde 2009 hasta hoy.
     * Euro:	Valores desde 1999 hasta hoy.
     * Imacec:	Valores desde 2004 hasta hoy.
     * Dólar observado:	Valores desde 1984 hasta hoy.
     * Tasa Política Monetaria (TPM):	Valores desde 2001 hasta hoy.
     * Indice de valor promedio (IVP):	Valores desde 1990 hasta hoy.
     * Indice de Precios al Consumidor (IPC):	Valores desde 1928 hasta hoy.
     * Dólar acuerdo:	Valores desde 1988 hasta hoy.
     * Unidad Tributaria Mensual (UTM):	Valores desde 1990 hasta hoy.
     * 
     * @return JSONArray.
     * @see org.json.JSONArray
     */
    public static JSONArray traerIndicadorJson() {
        String ruta = "http://www.mindicador.cl/api";
        JSONArray arr = new JSONArray();
        try {
            BufferedReader br = getDatos(ruta);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
                arr = new JSONArray(line);
            }
        } catch (IOException | JSONException ex) {
            System.out.println("Error al obtener los datos del WebService." + SEP + ex);
        }
        return arr;
    }
    
    /**
     * Función que retorna un String con el indicador requerido y la fecha indicada.
     * @param tipo {@code String}. El tipo de indicador a buscar. Ej:
     * "uf", "utm", "dolar".
     * @param fecha {@code String}. La fecha a buscar el valor en formato dd-mm-aaaa.
     * @return {@code String}. Con el valor del indicador para la fecha enviada.
     */
    public static String traerIndicadorTipoFecha(String tipo, String fecha) {
        String ruta = RUTA + tipo + "/" + fecha;
        try {
            BufferedReader br = getDatos(ruta);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            JSONArray arreglo = new JSONObject(builder.toString()).getJSONArray("serie");
            return arreglo.getJSONObject(0).get("valor").toString();
        } catch (IOException | JSONException ex) {
            System.out.println("No se pudo obtener el indicador: " + fecha + "." + SEP + ex);
            return "";
        }
    }
    
    /**
     * Función que retorna Arreglo JSON con todos los valores para las posibles fechas
     * del tipo de indicador seleccionado.
     * @param tipo {@code String}. Con el tipo de indicador a buscar.
     * @return {@code JSONArray}. Con todas las fechas posibles del indicador seleccionado.
     * 
     * Unidad de fomento (UF):	Valores desde 1977 hasta hoy.
     * Libra de Cobre:	Valores desde 2012 hasta hoy.
     * Tasa de desempleo:	Valores desde 2009 hasta hoy.
     * Euro:	Valores desde 1999 hasta hoy.
     * Imacec:	Valores desde 2004 hasta hoy.
     * Dólar observado:	Valores desde 1984 hasta hoy.
     * Tasa Política Monetaria (TPM):	Valores desde 2001 hasta hoy.
     * Indice de valor promedio (IVP):	Valores desde 1990 hasta hoy.
     * Indice de Precios al Consumidor (IPC):	Valores desde 1928 hasta hoy.
     * Dólar acuerdo:	Valores desde 1988 hasta hoy.
     * Unidad Tributaria Mensual (UTM):	Valores desde 1990 hasta hoy.
     * @see org.json.JSONArray
     */
    public static JSONArray traerIndicadorTipo(String tipo) {
        String ruta = RUTA + tipo;
        try {
            BufferedReader br = getDatos(ruta);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            JSONObject json = new JSONObject(builder.toString());
            JSONArray arreglo = json.getJSONArray("serie");
            return arreglo;
        } catch (IOException | JSONException ex) {
            System.out.println("Error al obtener los datos del WebService." + SEP + ex);
        }
        return new JSONArray();
    }

    private static BufferedReader getDatos(String ruta) {
        try {
            URL url = new URL(ruta);
            URLConnection urlc = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
            return br;
        } catch (IOException ex) {
            System.out.println("No se pudo conectar con la ruta." + SEP + ex);
            return null;
        }
    }
}