package com.ejercicios.jdbcapp;
import java.util.Date;
public class Curso {

    private int ID;
    private char Clave;
    private char Nombre;
    private char Descripcion;
    private int NoHorar;
    private Date FechaInicio;
    private Date FechaFin;
    private double Costo;
    private char Instructor;

    public Curso() {
    }

    public Curso(int ID, char clave, char nombre, char descripcion, int noHorar, Date fechaInicio, Date fechaFin, double costo, char instructor) {
        this.ID = ID;
        Clave = clave;
        Nombre = nombre;
        Descripcion = descripcion;
        NoHorar = noHorar;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        Costo = costo;
        Instructor = instructor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public char getClave() {
        return Clave;
    }

    public void setClave(char clave) {
        Clave = clave;
    }

    public char getNombre() {
        return Nombre;
    }

    public void setNombre(char nombre) {
        Nombre = nombre;
    }

    public char getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(char descripcion) {
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

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double costo) {
        Costo = costo;
    }

    public char getInstructor() {
        return Instructor;
    }

    public void setInstructor(char instructor) {
        Instructor = instructor;
    }
}
