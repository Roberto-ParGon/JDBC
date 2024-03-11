module com.ejercicios.jdbcapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ejercicios.jdbcapp to javafx.fxml;
    exports com.ejercicios.jdbcapp;
}