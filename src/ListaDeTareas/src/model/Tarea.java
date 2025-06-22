/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vicen
 * 
 * Clase que representa una tarea individual(Plantilla)
 * para generar una tarea y todas
 * 
 * Prototype -> Clonaremos la tarea
 * 
 */
public class Tarea implements Cloneable{
    private int id;
    private String titulo;
    private String descripcion;
    private String fecha;
    private int prioridad;
    private boolean completada;
    private static int contadorId = 1;
    
    

    public Tarea() {
    }

    /**
     * Esta usaremos ya en la otra nos solicitaba id en esta no el id lo tenemos como statico entonces comenzara desde 1 
     */
    public Tarea(String titulo, String descripcion, String fecha, int prioridad) {
    this.id = contadorId++;
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.fecha = fecha;
    this.prioridad = prioridad;
    this.completada = false;
}

    
    public Tarea(int id, String titulo, String descripcion, String fecha, int prioridad, boolean completada) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
    
    
    /**
     * Metodo de tarea como clonador -> llamada copia  donde instanciaremos una 
     * nueva tarea  identica (Con los mismos valores) a la actual por eso el this.variable
     */
    public Tarea clone(){
    return new Tarea(this.titulo, this.descripcion, this.fecha, this.prioridad);
    }
    
    /**
     * Mostremos la tarea como texto
     */
    @Override
    public String toString(){
        return "ID: " + id + " | " +
               "Titulo: " + titulo + " | " +
               "Descripcion: " + descripcion + " | " +
               "Fecha: " + fecha + " | " +
               "Prioridad: " + prioridad + " | " +
               "Completada: " + (completada ? "Si" : "No");
    }
    
    
}
