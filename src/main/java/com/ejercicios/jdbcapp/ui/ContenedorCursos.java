package com.ejercicios.jdbcapp.ui;

import com.ejercicios.jdbcapp.helpers.CursosHelper;
import com.ejercicios.jdbcapp.modelos.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.util.Date;
import java.util.List;


public class ContenedorCursos extends BorderPane {

    private TableView<Curso> tablaCursos;
    private TableColumn<Curso, String> colClave;
    private TableColumn<Curso, String> colNombre;
    private TableColumn<Curso, String> colInstructor;
    private TableColumn<Curso, Integer> colnoHoras;
    private TableColumn<Curso, Date> colfechaInicio;
    private TableColumn<Curso, Date> colfechaTermino;
    private TableColumn<Curso, String> colDescripcion;
    private TableColumn<Curso, Double> colCosto;


    private ObservableList<Curso> listaCursos;

    public ContenedorCursos() {
        inicializarComponentes();
        cargarDatos();
    }

    private void cargarDatos() {
        CursosHelper ch = new CursosHelper();
        List<Curso> cursos = ch.obtenerListaCursos();
        listaCursos = FXCollections.observableList(cursos);
        tablaCursos.setItems(listaCursos);
    }


    private void inicializarComponentes() {
        tablaCursos = new TableView<Curso>();

        colClave = new TableColumn<Curso, String>("Clave");
        colClave.setCellValueFactory(new PropertyValueFactory<Curso, String>("Clave"));

        colNombre = new TableColumn<Curso, String>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<Curso, String>("Nombre"));
        colNombre.setMaxWidth(200);

        colDescripcion = new TableColumn<Curso, String>("Descripcion");
        colDescripcion.setCellValueFactory(new PropertyValueFactory<Curso, String>("Descripcion"));
        colDescripcion.setMaxWidth(200);

        colnoHoras = new TableColumn<Curso, Integer>("NoHorar");
        colnoHoras.setCellValueFactory(new PropertyValueFactory<Curso, Integer>("NoHorar"));

        colfechaInicio = new TableColumn<Curso, Date>("FechaInicio");
        colfechaInicio.setCellValueFactory(new PropertyValueFactory<Curso, Date>("FechaInicio"));

        colfechaTermino = new TableColumn<Curso, Date>("FechaTermino");
        colfechaTermino.setCellValueFactory(new PropertyValueFactory<Curso, Date>("FechaTermino"));

        colCosto = new TableColumn<Curso, Double>("Costo");
        colCosto.setCellValueFactory(new PropertyValueFactory<Curso, Double>("Costo"));

        colInstructor = new TableColumn<Curso, String>("Instructor");
        colInstructor.setCellValueFactory(new PropertyValueFactory<Curso, String>("Instructor"));
        colInstructor.setMaxWidth(200);

        tablaCursos.getColumns().addAll(colClave, colNombre, colDescripcion, colnoHoras, colfechaInicio, colfechaTermino, colCosto, colInstructor);

        TitledPane panelCursos = new TitledPane();
        panelCursos.setText("Cursos");
        panelCursos.setContent(tablaCursos);
        panelCursos.setCollapsible(false);

        TitledPane panelOperacions = new TitledPane();
        panelOperacions.setText("Cursos");
        panelCursos.setContent(tablaCursos);
        panelCursos.setCollapsible(false);

        setCenter(panelCursos);
    }
}
