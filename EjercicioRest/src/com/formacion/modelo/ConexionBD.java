package com.formacion.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	public static Connection Conexion() {
        Connection conex = null;
        //VARIABLES DE CONEXION
        String servidor = "localhost";
        String database = "mf0966_3?serverTimezone=UTC";
        String usuario = "root";
        String password = "";
        String url = "";
        System.out.println("---------------------------------------------------------");
        try {
            //Indica al interprete de Java que en tiempo real mande a cargar la libreria jdbc
            Class.forName("com.mysql.jdbc.Driver");
            //cadena con datos de servidor
            url = "jdbc:mysql://" + servidor + "/" + database;
            //variable de conexion obteniendo el servidor , usuario y password
            conex = DriverManager.getConnection(url, usuario, password);
            System.out.println(" Conexion a Base de Datos: " + url + " --> Ok ");
        } //mandamos mensaje de error por url o error de conexion
        catch (SQLException ex) {
            System.out.println("Error Cadena: " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Clase Conexion: " + ex);
        }
        return conex;
    }
}
