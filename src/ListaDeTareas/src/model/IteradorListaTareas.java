/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author vicen
 * 
 * Implementacion de iteradorTareas la cual permite recorrer la lista de tarea sin exponer su extructura
 * 
 */
public class IteradorListaTareas implements IteratorTareas {

   private final List<Tarea> lista;
    private int posicion = 0;

    public IteradorListaTareas(List<Tarea> lista){
        this.lista = lista; 
    }
    
    

     @Override
    public boolean haySiguiente(){
        return posicion < lista.size();
    }

    @Override
    public Tarea siguiente() {
        if (haySiguiente()) {
            return lista.get(posicion++);
        }
        return null;
    }
    
}
