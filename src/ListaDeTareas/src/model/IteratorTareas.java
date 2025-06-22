/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vicen
 * 
 * interface que definie los metodos para iterar la lista de tareas para el patron iterator
 * 
 */
public interface IteratorTareas {
    
     boolean haySiguiente();
    Tarea siguiente();
    
}
