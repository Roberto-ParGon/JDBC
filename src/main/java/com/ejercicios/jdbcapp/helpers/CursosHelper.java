package com.ejercicios.jdbcapp.helpers;

import com.ejercicios.jdbcapp.modelos.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CursosHelper {
    public List<Curso> obtenerListaCursos() {
        try {
            Connection conn = ConexionDBCursos.obtenerInstancia();

            Statement inst = conn.createStatement();
            ResultSet resultadoCursos = inst.executeQuery("select * from curso order by nombre");
            List<Curso> listaCursos = new ArrayList<>();
            while (resultadoCursos.next()) {
                //String id = resultadoCursos.getInt("ID");
                String clave = resultadoCursos.getString("Clave");
                String nombre = resultadoCursos.getString("Nombre");
                String descripcion = resultadoCursos.getString("Descripcion");
                String instructor = resultadoCursos.getString("Instructor");
                int noHorar = resultadoCursos.getInt("NoHorar");
                Date fechaInicio = resultadoCursos.getDate("FechaInicio");
                Date fechaTermino = resultadoCursos.getDate("FechaTermino");
                double costo = resultadoCursos.getDouble("Costo");

                Curso curso = new Curso(clave, nombre, descripcion, noHorar, fechaInicio, fechaTermino, costo, instructor);
                listaCursos.add(curso);
            }
            return listaCursos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void agregarCurso(Curso curso) {
        try {

            Connection conn = ConexionDBCursos.obtenerInstancia();
            Statement inst = conn.createStatement();
            String FechaInicio = "2024-0-01";
            String FechaTermino = "2021-01-01";
            String querySQL = String.format("insert into curso (Clave, Nombre, Descripcion, NoHorar, FechaInicio, FechaTermino, Costo, Instructor) values ('%s', '%s', '%s', '%d', '%s', '%s', '%f', '%s')", curso.getClave(), curso.getNombre(), curso.getDescripcion(), curso.getNoHorar(), FechaInicio, FechaTermino, curso.getCosto(), curso.getInstructor());

            inst.executeUpdate(querySQL);
        } catch (Exception e) {
        }
    }

}