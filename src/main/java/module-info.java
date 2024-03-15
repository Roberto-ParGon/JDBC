module com.ejercicios.jdbcapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ejercicios.jdbcapp to javafx.fxml;
    exports com.ejercicios.jdbcapp;
    exports com.ejercicios.jdbcapp.modelos;
    exports com.ejercicios.jdbcapp.helpers;
    opens com.ejercicios.jdbcapp.modelos to javafx.fxml;
}