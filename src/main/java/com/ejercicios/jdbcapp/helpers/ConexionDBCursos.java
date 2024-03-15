package com.ejercicios.jdbcapp.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDBCursos {
    private static Connection conn=null;
    protected ConexionDBCursos() {

    }
    public static Connection obtenerInstancia() throws Exception {
        if (conn == null) {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cursos?user=root&password=root");
        }
        return conn;
    }

}