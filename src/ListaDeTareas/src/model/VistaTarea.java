/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vicen
 * 
 * Clase puente del patrón Bridge. Contiene una instancia de 
visualización
 */
public class VistaTarea {
    
    protected VistaTareaImpl implementacion;
    
     public VistaTarea(VistaTareaImpl implementacion) {
        this.implementacion = implementacion;
    }

    public void mostrar(Tarea tarea) {
        implementacion.mostrarTarea(tarea);
    }
    
}
