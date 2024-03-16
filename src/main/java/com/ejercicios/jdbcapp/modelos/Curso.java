package com.ejercicios.jdbcapp.modelos;

import java.util.Date;

public class Curso {
    private String Clave;
    private String Nombre;
    private String Descripcion;
    private int NoHorar;
    private Date FechaInicio;
    private Date FechaTermino;
    private double Costo;
    private String Instructor;

    public Curso(String clave, String nombre, String descripcion, int noHoras, Date fechaInicio, Date fechaTermino, double costo, String instructor) {
        Clave = clave;
        Nombre = nombre;
        Descripcion = descripcion;
        NoHorar = noHoras;
        FechaInicio = fechaInicio;
        FechaTermino = fechaTermino;
        Costo = costo;
        Instructor = instructor;
    }

    public Curso() {
    }

    public Curso(int id, String clave, String nombre, String descripcion, String instructor, int noHorar, java.sql.Date fechaInicio, java.sql.Date fechaTermino, double costo) {
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getNoHorar() {
        return NoHorar;
    }

    public void setNoHorar(int noHorar) {
        NoHorar = noHorar;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return FechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        FechaTermino = fechaTermino;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double costo) {
        Costo = costo;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }
}
