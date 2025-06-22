/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vicen
 * 
 * otra implementacion de vistaTareaImpl muestra los detalles de manera detallada
 * 
 */
public class VistaDetalladaImpl implements VistaTareaImpl{
    
        @Override
    public void mostrarTarea(Tarea tarea) {
        System.out.println("---- Vista Detallada ----");
        System.out.println("ID: " + tarea.getId());
        System.out.println("Titulo: " + tarea.getTitulo());
        System.out.println("Descripcion: " + tarea.getDescripcion());
        System.out.println("Fecha: " + tarea.getFecha());
        System.out.println("Prioridad: " + tarea.getPrioridad());
        System.out.println("--------------------------");
    }
    
}
