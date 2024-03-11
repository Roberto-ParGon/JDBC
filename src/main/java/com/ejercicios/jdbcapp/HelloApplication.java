package com.ejercicios.jdbcapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        //Declarar credenciales de acceso a la base de datos
        String driverJDBC = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/cursos";
        String user = "root";
        String password = "root";
        //String connectionFull = "jdbc:mariadb://localhost:3306/cursos?user=root&password=root";
        Statement stmt = null;
        try {
            //Registrar el driver JDBC
            Class.forName(driverJDBC);

            //Abrir conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión realizada a la base de datos");

            //Realizar una query
            stmt = connection.createStatement();
            String sql = "SELECT * from curso;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Recuperar las columnas
                int id = rs.getInt("ID");
                String nombre = rs.getString("Nombre");
                //Imprimir los valores
                System.out.println("ID: " + id + ", Nombre: " + nombre);
            }

        } catch (SQLException se) {
            //Handle errors para JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors para Class.forName
            e.printStackTrace();
        } finally {
            //block finally para cerrar recursos
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Finalización de conexión");
    }
}

