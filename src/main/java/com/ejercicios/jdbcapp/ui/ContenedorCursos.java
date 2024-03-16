package com.ejercicios.jdbcapp.ui;

import com.ejercicios.jdbcapp.helpers.CursosHelper;
import com.ejercicios.jdbcapp.modelos.Curso;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import java.time.LocalDate;
import java.time.ZoneId;
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

    private TitledPane paneCursos;
    private TitledPane paneOperacionesCursos;
    private Button btnAgregar;
    private Button btnModificar;
    private Button btnEliminar;
    private TitledPane paneEdicionCursos;
    private Label etiClave;
    private TextField txtClave;
    private Label etiNombre;
    private TextField txtNombre;
    private Label etiDescripcion;
    private TextArea txtDescripcion;
    private Label etiInsructor;
    private TextField txtInstructor;
    private Label etiNoHoras;
    private Spinner<Integer> spNoHoras;
    private Label etiCosto;
    private Spinner<Double> spCosto;
    private Label etiFechaInicio;
    private DatePicker dpFechaInicio;
    private Label etiFechaTermino;
    private DatePicker dpFechaTermino;


    private ObservableList<Curso> listaCursos;

    public ContenedorCursos() {
        inicializarComponentes();
        cargarDatos();
        crearPanelEdicionCurso(); //Método en constructor

    }

    //Método para creación del panel de edición de cursos
    private void crearPanelEdicionCurso() {
        paneEdicionCursos = new TitledPane();
        paneEdicionCursos.setText("Captura de los Datos de un Curso");
        paneEdicionCursos.setMinWidth(250);

        VBox contenedorCampos = new VBox();
        contenedorCampos.setSpacing(5);
        contenedorCampos.setPadding(new javafx.geometry.Insets(10, 30, 10 ,30));
        LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.ALICEBLUE), new Stop(1, Color.BLUEVIOLET));
        contenedorCampos.setBackground(new Background(new BackgroundFill(linearGradient, null, null)));
        etiClave = new Label("Clave");
        txtClave = new TextField("");
        txtClave.setPromptText("Clave del curso");

        etiNombre = new Label("Nombre");
        txtNombre = new TextField("");
        txtNombre.setPromptText("Nombre del curso");

        etiDescripcion = new Label("Descripción");
        txtDescripcion = new TextArea("");
        txtDescripcion.setPromptText("Descripción del curso");
        txtDescripcion.setPrefColumnCount(20);
        txtDescripcion.setPrefRowCount(3);

        etiInsructor = new Label("Instructor");
        txtInstructor = new TextField("");
        txtInstructor.setPromptText("Nombre del instructor");

        etiNoHoras = new Label("No. Horas");
        spNoHoras = new Spinner<Integer>(10, 80, 20);
        spNoHoras.setPromptText("No. Horas");

        etiCosto = new Label("Costo");
        spCosto = new Spinner<Double>(100.0, 5000.0, 1000.0);
        spCosto.setPromptText("Costo");

        etiFechaInicio = new Label("Fecha de Inicio");
        dpFechaInicio = new DatePicker(LocalDate.now().plusDays(1));
        dpFechaInicio.setPromptText("DD/MM/AAAA");

        etiFechaTermino = new Label("Fecha de Termino");
        dpFechaTermino = new DatePicker(LocalDate.now().plusDays(31));
        dpFechaTermino.setPromptText("DD/MM/AAAA");

        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button("Cancelar");

        cancelar.setOnAction(evt -> {
           ocultarPanelDerecho();
        });

        aceptar.setOnAction(evt -> {
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Curso curso = new Curso();
            curso.setClave(txtClave.getText());
            curso.setNombre(txtNombre.getText());
            curso.setDescripcion(txtDescripcion.getText());
            curso.setNoHorar((int) spNoHoras.getValue());
            curso.setFechaInicio(java.sql.Date.valueOf(dpFechaInicio.getValue()));
            curso.setFechaTermino(java.sql.Date.valueOf(dpFechaTermino.getValue()));
            curso.setCosto((double) spCosto.getValue());
            curso.setInstructor(txtInstructor.getText());


            if(guardarCurso(curso)){
                ocultarPanelDerecho();

            }else{
                return;
            }

            });

        HBox panelBotonesCurso = new HBox();
        panelBotonesCurso.setSpacing(10);
        panelBotonesCurso.setPadding(new Insets(10, 0, 10, 0));
        panelBotonesCurso.getChildren().addAll(aceptar, cancelar);

        contenedorCampos.getChildren().addAll(etiClave, txtClave, etiNombre, txtNombre,
                etiDescripcion, txtDescripcion, etiInsructor, txtInstructor, etiNoHoras, spNoHoras, etiCosto, spCosto,
        etiFechaInicio, dpFechaInicio, etiFechaTermino, dpFechaTermino, panelBotonesCurso);

        paneEdicionCursos.setContent(new ScrollPane(contenedorCampos));

    }

    private boolean guardarCurso(Curso curso) {
        CursosHelper ch = new CursosHelper();
        ch.agregarCurso(curso);
        return true;
    }

    private void ocultarPanelDerecho() {
        setRight(null);
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


        //Creación del panel lateral
        paneCursos = new TitledPane();
        paneCursos.setText("Lista de Cursos Registrados");
        paneCursos.setContent(tablaCursos);
        paneCursos.setCollapsible(false);

        HBox contenedorBotones = new HBox();
        btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(evt -> {
            setRight(paneEdicionCursos);
        });
        btnModificar = new Button("Modificar");
        btnEliminar = new Button("Eliminar");
        btnModificar.setDisable(true);
        btnEliminar.setDisable(true);
        contenedorBotones.getChildren().addAll(btnAgregar, btnModificar, btnEliminar);

        paneOperacionesCursos = new TitledPane();
        paneOperacionesCursos.setText("Operaciones sobre cursos");
        paneOperacionesCursos.setContent(contenedorBotones);
        paneOperacionesCursos.setCollapsible(false);

        setCenter(paneCursos);
        setBottom(paneOperacionesCursos);
    }
}
