/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.Scanner;
import model.GestorTareas;
import model.IteradorListaTareas;
import model.IteratorTareas;
import model.Tarea;
import model.VistaDetalladaImpl;
import model.VistaResumenImpl;
import model.VistaTarea;

/**
 *
 * @author vicen
 * instaciare a la clase Scanner para poder usarla y despues instanciar Menu en AppTareas 
 */
public class Menu {
    private final GestorTareas gestor = GestorTareas.obtenerInstancia();
    private final Scanner scanner = new Scanner(System.in);
    
    
    
   /**
    *  Metodo del MostrarMenu
    * 
    * Su funcionalidad es el menu en si  
    * Su menu de presentacion 
    * Crear Tareas 
    * Ver Tareas
    * Eliminar Tarea
    * Clonar Tareas
    * Salir del programa 
    * 
    * lo hice un con un do while para ejecute el menu y despues va a validar su 
    * condiciones 
    * adentro existe un switch 
    * 
    */
    public void  mostrarMenu(){
        int opcionMenu;
        
        /**
         * Menu 
         * Elija una opcion de 1 a 7 
         * cae en el String input y validamos si no existe una letra su existe una 
         * letra la dejamos como -1 que es una opcion invalida
         * opcionMenu llevara al switch la opciones 
         */
        
        do{
            System.out.println("-----Menu de tareas----");
            System.out.println("1. Crear Tareas");
            System.out.println("2. Ver Tareas");
            System.out.println("3. Eliminar Tarea");
            System.out.println("4. Actualizar Tarea");
            System.out.println("5. Clonar Tarea");
            System.out.println("6. Marcar Tarea como completada");
            System.out.println("7. Salir");
            System.out.print("Selecciona tu opcion: ");
            
             String input = scanner.nextLine();
        try {
            opcionMenu = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            opcionMenu = -1; 
        }
            
       
            switch (opcionMenu) {
                case 1:
                    
                    /**
                     * 
                     * Al ingresar a crear tareas 
                     * Nos solicita el titulo , descripcion , fecha , e ingresa su prioridad 
                     * 1 a 3 
                     * 
                     * una vez obtenemos los datos instanciamos la clase tarea 
                     * y llamamos al segundo constructor 
                     * y con break nos devuelve a menu principal
                     * 
                     */
                    
                    System.out.println("----_Crear Tareas_----");
           
                    System.out.println("Ingresa Titulo: ");
                    String titulo = scanner.nextLine();
                    
                    System.out.println("Ingresa Descripcion: ");
                    String descripcion = scanner.nextLine();
                    
                    System.out.println("Ingresa Fecha: ");
                    String fecha = scanner.nextLine();
                    
                    System.out.println("Ingresa Prioridad Numerica : ");
                    System.out.println("1. Prioridad Baja ");
                    System.out.println("2. Prioridad Media ");
                    System.out.println("3. Prioridad Alta ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();
                    
                    Tarea tarea = new Tarea(titulo, descripcion, fecha, prioridad);
                    gestor.agregarTarea(tarea);
                    
                    break;

                case 2:
                    
                    
                    /**
                     * Lista de tarea nos devuelve los registros que tenemos 
                     * como el gestor es la clase mas importante del crud 
                     * validamos en gestor en el metodo obtener tareas si esta vacio 
                     * nos devuelve no hay tareas registradas
                     * 
                     * si contiene 
                     * 
                     * el iterdado tarea 
                     * en bucle while el iterador con el metodo haysiguiente 
                     * nos devuelve los datos e imprimirlos sin exponer si estructura
                     */
                System.out.println("----_Lista de tareas_----");
                
                    if (gestor.obtenerTareas().isEmpty()) {
                        System.out.println("NO HAY TAREAS REGISTRADAS");
                    }else{
                        
                     IteratorTareas iterador = new IteradorListaTareas(gestor.obtenerTareas());
                      while (iterador.haySiguiente()) {
                       Tarea t = iterador.siguiente();
                       System.out.println(t);
                      }
                        
                    }
                
                
                    break;
                case 3:
                    
                    /**
                      * Eliminar tarea  buscamos primero en el gestor.obtener tareas si esta vacio
                      * nos devuelve un mensaje
                      * que no hay tareas registradas
                      * instanciamos el iterador y llamamos obtener tareas
                      * la recorre igual y las imprime
                      * 
                      * despues consulta que id de la tarea va a eliminar 
                      * en la cual esta en gestor.buscaPorId(1);
                      * en este caso si fuera asi el ejemplo eliminaria el 1 
                      * la cual va ir variando 
                      * si la encuenta la elimina si no nos dice no se encontro
                      * tal tarea
                      * 
                      * 
                      */
                    
                       System.out.println("----_Eliminar Tarea_----");
                       
                       if(gestor.obtenerTareas().isEmpty()){
                System.out.println("NO HAY TAREAS REGISTRADAS");

                       }else{
                           
                     IteratorTareas iterador = new IteradorListaTareas(gestor.obtenerTareas());
                      while (iterador.haySiguiente()) {
                       Tarea t = iterador.siguiente();
                       System.out.println(t);
                      }
                       
                        System.out.println("Ingrese el Id de la tarea a eliminar: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        
                        Tarea encontrada = gestor.buscarPorId(id);
                        
                        if(encontrada!= null){
                        gestor.eliminarTarea(id);
                            System.out.println("Tarea eliminada correctamente");
                        }else{
                            System.out.println("No se encontro ninguna tarea con ese id");
                        }
                        
                       }
                    
                    
                    break;
                case 4:
                    
                    // actualizar
                System.out.println("----_Actualizar Tarea_----");

                        
                 if(gestor.obtenerTareas().isEmpty()){
                System.out.println("NO HAY TAREAS REGISTRADAS");

                       }else{
                           
                     IteratorTareas iterador = new IteradorListaTareas(gestor.obtenerTareas());
                      while (iterador.haySiguiente()) {
                       Tarea t = iterador.siguiente();
                       System.out.println(t);
                      }
                      
                      
                    
                  System.out.print("Ingrese el ID de la tarea a actualizar: ");
                 int idActualizar = scanner.nextInt();
                 scanner.nextLine();  
                      
                 
                 Tarea tareaup = gestor.buscarPorId(idActualizar);
                 
                 if(tareaup != null){
                 
                     System.out.println("Seleccione tipo de vista: ");
                     System.out.println("1. Vista detallada ");
                     System.out.println("2. Vista Resumen ");
                     int vistaSeleccion = scanner.nextInt();
                     scanner.nextLine();
                     
                     VistaTarea vista;
                     
                     if(vistaSeleccion == 1){
                     vista = new VistaTarea(new VistaDetalladaImpl());
                     
                     }else{
                     vista = new VistaTarea(new VistaResumenImpl());
                     }
                     vista.mostrar(tareaup);

                    System.out.print("Ingrese nuevo titulo: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Ingrese nueva descripcion: ");
                    String nuevaDescripcion = scanner.nextLine();
                    System.out.print("Ingrese nueva fecha: ");
                    String nuevaFecha = scanner.nextLine();
                    System.out.println("Ingrese nueva prioridad ");
                    System.out.println("1. Prioridad Baja ");
                    System.out.println("2. Prioridad Media ");
                    System.out.println("3. Prioridad Alta ");
                    int nuevaPrioridad = scanner.nextInt();
                    scanner.nextLine();
            
                    // Actualizar los datos
                    tareaup.setTitulo(nuevoTitulo);
                    tareaup.setDescripcion(nuevaDescripcion);
                    tareaup.setFecha(nuevaFecha);
                    tareaup.setPrioridad(nuevaPrioridad);
                    
                     System.out.println("Tarea actualizada correctamente");
                     
                     
            
                     
                 }else{
                     System.out.println("No se encontro una tarea con ese id");
                 }
                 
                 
                      
                 }

                    
                    
                    break;
                case 5:
                    
                    // clonar 
                   System.out.println("----_Clonar Tarea_----");
   
                    if (gestor.obtenerTareas().isEmpty()) {
                        
                                        System.out.println("NO HAY TAREAS REGISTRADAS");

                    }else{
                         
                        
                        IteratorTareas iterador = new IteradorListaTareas(gestor.obtenerTareas());
                      while (iterador.haySiguiente()) {
                       Tarea t = iterador.siguiente();
                       System.out.println(t);
                      }
                      
                        System.out.print("Ingrese el ID de la tarea a clonar: ");
                       int idClonar = scanner.nextInt();
                       scanner.nextLine();

                       Tarea original = gestor.buscarPorId(idClonar);

                       if (original != null) {
                           Tarea clonada = original.clone(); 
                           gestor.agregarTarea(clonada);     
                           System.out.println("Tarea clonada exitosamente:");
                           System.out.println(clonada);
                       } else {
                           System.out.println("No se encontró una tarea con ese ID.");
                       }
                    
                    }
                    
                    
                    break;
                case 6:
                    // Marcar Tarea como lista 
                     System.out.println("----_Marcar Tarea como Completada_----");
                    if (gestor.obtenerTareas().isEmpty()) {
        System.out.println("NO HAY TAREAS REGISTRADAS");
    }else {
        IteratorTareas iterador = new IteradorListaTareas(gestor.obtenerTareas());
        while (iterador.haySiguiente()) {
            Tarea t = iterador.siguiente();
            System.out.println(t);
        }

        System.out.print("Ingrese el ID de la tarea a marcar como completada: ");
        int idCompletada = scanner.nextInt();
        scanner.nextLine();

        Tarea tareaa = gestor.buscarPorId(idCompletada);

        if (tareaa != null) {
            if (!tareaa.isCompletada()) {
                tareaa.setCompletada(true);
                System.out.println("Tarea marcada como completada.");
            } else {
                System.out.println("La tarea ya estaba completada.");
            }
        } else {
            System.out.println("No se encontró una tarea con ese ID.");
        }
    }
                    
                    break;
                case 7:
                    //salir
                    break;
                default:
                   System.out.println("Opcion invalida. Intente nuevamente.");
            }
            
            
        }while(opcionMenu!=7);
        
    
    }
    
    
}
