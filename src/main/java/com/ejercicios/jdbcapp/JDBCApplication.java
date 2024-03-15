package com.ejercicios.jdbcapp;

import com.ejercicios.jdbcapp.ui.ContenedorCursos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JDBCApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var root = new ContenedorCursos();
        Scene scene = new Scene(root, 790, 200);
        stage.setTitle("Cursos");
        stage.setScene(scene);
        stage.show();
    }
}

