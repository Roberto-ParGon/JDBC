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
}