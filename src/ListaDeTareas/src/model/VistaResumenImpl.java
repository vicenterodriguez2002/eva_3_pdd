/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vicen
 * implementacion concreta de vistaTareaImple 
 * es una muestra mas sencilla 
 * Muestra el id , titulo y fecha
 */
public class VistaResumenImpl implements VistaTareaImpl{
    
    @Override
    public void mostrarTarea(Tarea tarea){
  
        System.out.println("[" + tarea.getId() + "] " + tarea.getTitulo() + " (" + tarea.getFecha() + ")");
    
    }
    
}
