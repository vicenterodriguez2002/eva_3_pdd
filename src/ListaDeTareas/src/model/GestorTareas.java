/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vicen
 * 
 * Singleton 
 * 
 * Tendremos una lista de tarea desde la clase Tarea (Variable privada)
 * luego tenemos una instancia de nuestra clase propia en privada para que no pueda
 * ser instancia de directamente 
 * 
 */
public class GestorTareas {
    
    private List<Tarea> tareas;
    private static GestorTareas instancia;

 
    /**
     * Constructor privada para Singlenton  
     */
    
    private GestorTareas (){
    
        tareas = new ArrayList<>();
     
    }
    
    /**
     * Metodo singleton getInstance 
     * obtenerInstancia (getInstance)
     * si la instancia es nula 
     * creamos una nueva instancia GestorTareas();
     * y retornamos la instancia
     * 
     */
    
    public static GestorTareas obtenerInstancia(){
        
        if (instancia == null) {
          instancia = new GestorTareas();
        }
        return instancia;
    }
    
    /**
     * Agregar Tarea
     */
    
    public void agregarTarea(Tarea tarea){
    
        tareas.add(tarea);
 
    }
    
    /**
     * Eliminar tarea por su id
     * usaremos removeIf ua qie esta en una colleccion de datos y nosotros
     * necesitamos verificar la condicion
     */
    
    public void eliminarTarea (int id){
    
    tareas.removeIf(t -> t.getId() == id);
        
    }
    
    
    /**
     * Buscaremos la tarea x su id
     */
    
    public Tarea buscarPorId(int id){
    
        for (Tarea tareita : tareas){
        
            if (tareita.getId() == id) {
                
                return tareita;
            }
        
        }
        return null;
        
    }
    
    /**
     * Metodo para obtenerTareas  en la cual retorna la lista de tareas
     */
    public List<Tarea> obtenerTareas(){
    
    return tareas;
        
    }
    
    
    
}
