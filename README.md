# Sistema de lista de tareas
Nombre: Vicente Ignacio Rodriguez Cancino | Sección 1 (14:56 - 16:25) | Asignatura: Patrones de Diseño

### Descripción general

El objetivo de este sistema es desarrollar una aplicación en Java que implemente los patrones de diseño GoF. La aplicación permite gestionar tareas de forma eficiente, ofreciendo funcionalidades como la creación, listado, actualización, eliminación, clonación de tareas y la opción de marcarlas como completadas.

### Problema a resolver 
En el día a día, las personas suelen enfrentar múltiples tareas y responsabilidades. Sin una organización adecuada, es común olvidar compromisos importantes, llegar tarde o entregar tareas fuera de plazo. 

este sistema busca permitir una gestión eficiente y ordenada de las actividades diarias. A través de su interfaz, el usuario puede crear, visualizar, actualizar, eliminar, clonar y marcar tareas como completadas, facilitando así una mejor planificación personal.

### Diagramas 
---
__Caso de uso__<br>
![Caso de uso](<img/Caso de uso.png>)
<br>
__Diagrama de clases__
![Diagrama de clase](<img/patron diagrama de clases.png>)

---

### Patrones aplicados y su justificación.

###  1. **Patrón Creacional: Prototype**
**Donde** : Clase `Tarea` y su clonación.<br>
**Por qué*** : Se utiliza para duplicar tareas que ya existen , ya que sin necesidad de crear una nueva podemos reutilizar una que ya tenemos.<br>
**Como** : se implemte en metodo clone() para replicar la tarea.

```java
public Tarea clone(){
    return new Tarea(this.titulo, this.descripcion, this.fecha, this.prioridad);
}
```

---
### 2. **Patrón Estructural: Bridge**

**Donde** : Clases `VistaTarea` (abstracción) y `VistaTareaImpl` (implementor), junto con `VistaDetalladaImpl` y `VistaResumenImpl`. <br>
**Por qué*** : Permite separar la abstracción de la implementación, facilitando nuevas formas de visualizar las tareas sin modificar su estructura.<br>
**Como** : Se define una interfaz para representar la vista general de una tarea y diferentes implementaciones para mostrarla de forma detallada o resumida.

```java
public class VistaTarea {
    
    protected VistaTareaImpl implementacion;
    
     public VistaTarea(VistaTareaImpl implementacion) {
        this.implementacion = implementacion;
    }

    public void mostrar(Tarea tarea) {
        implementacion.mostrarTarea(tarea);
    }
    
}

```
---

```java
public interface VistaTareaImpl {
    void mostrarTarea(Tarea tarea);
}


```
---
```java
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



```

---
```java
public class VistaResumenImpl implements VistaTareaImpl{
    
    @Override
    public void mostrarTarea(Tarea tarea){
  
        System.out.println("[" + tarea.getId() + "] " + tarea.getTitulo() + " (" + tarea.getFecha() + ")");
    
    }
    
}

```

---

### 3. **Patrón de Comportamiento: Iterator**

**Donde** : Clase `IteradorTareas` (interface) y  `IteradorListaTareas`<br>
**Por qué*** : Permite recorrer una lista de datos sin exponer su extructura interna. <br>
**Como** : Se crea un iterador personalizado para recorrer y mostrar las tareas una por una.

```java

public interface IteratorTareas {
    
     boolean haySiguiente();
    Tarea siguiente();
    
}

```

---

```java

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

```
---


### 4. **Patrón Libre elección: Singleton**

**Donde** : Clase `GestorTarea` <br>
**Por qué*** : Asegura que exista una sola instancia del gestor de tarea durante su ejecución. <br>
**Como** : Se impletanta un metodo estatico y retorna siempre la misma instacia.

```java

public class GestorTareas {
    
    private List<Tarea> tareas;
    private static GestorTareas instancia;

    private GestorTareas (){
    
        tareas = new ArrayList<>();
     
    }
        
    public static GestorTareas obtenerInstancia(){
        
        if (instancia == null) {
          instancia = new GestorTareas();
        }
        return instancia;
    }
}

// Este codigo fue cortado, el codigo completo se encuentra en src.
```


---
### Instrucciones de compilación y ejecución.
```bash
cd Evaluacion3_PDD
javac -d bin `
src/ListaDeTareas/src/app/AppTareas.java `
src/ListaDeTareas/src/app/Menu.java `
src/ListaDeTareas/src/model/*.java
java -cp bin app.AppTareas
```
---



# Ejemplo de uso

```
-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 1



----_Crear Tareas_----
Ingresa Titulo:
Evaluacion de patrones de diseño
Ingresa Descripcion:
Evaluacion numero 3 de patrones de diseño
Ingresa Fecha:
26 de junio del 2025
Ingresa Prioridad Numerica :
1. Prioridad Baja
2. Prioridad Media
3. Prioridad Alta
3



-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 2




----_Lista de tareas_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 5



----_Clonar Tarea_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
Ingrese el ID de la tarea a clonar: 1
Tarea clonada exitosamente:
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No



-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 2




----_Lista de tareas_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No




-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 4




----_Actualizar Tarea_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
Ingrese el ID de la tarea a actualizar: 2
Seleccione tipo de vista:
1. Vista detallada
2. Vista Resumen
1




---- Vista Detallada ----
ID: 2
Titulo: Evaluacion de patrones de dise?o
Descripcion: Evaluacion numero 3 de patrones de dise?o
Fecha: 26 de junio del 2025
Prioridad: 3
--------------------------
Ingrese nuevo titulo: Evaluacion de patrones de diseño
Ingrese nueva descripcion: Evaluacion numero 3 de patrones de diseño
Ingrese nueva fecha: 27 de junio del 2025
Ingrese nueva prioridad
1. Prioridad Baja
2. Prioridad Media
3. Prioridad Alta
3
Tarea actualizada correctamente




-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 2
----_Lista de tareas_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o | Fecha: 27 de junio del 2025 | Prioridad: 3 | Completada: No





-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 6







----_Marcar Tarea como Completada_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: No
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o | Fecha: 27 de junio del 2025 | Prioridad: 3 | Completada: No
Ingrese el ID de la tarea a marcar como completada: 1
Tarea marcada como completada.
-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 6






----_Marcar Tarea como Completada_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: Si
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o | Fecha: 27 de junio del 2025 | Prioridad: 3 | Completada: No
Ingrese el ID de la tarea a marcar como completada: 2
Tarea marcada como completada.
-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 2






----_Lista de tareas_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: Si
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o | Fecha: 27 de junio del 2025 | Prioridad: 3 | Completada: Si
-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 3






----_Eliminar Tarea_----
ID: 1 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o  | Fecha: 26 de junio del 2025 | Prioridad: 3 | Completada: Si
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o | Fecha: 27 de junio del 2025 | Prioridad: 3 | Completada: Si
Ingrese el Id de la tarea a eliminar:
1
Tarea eliminada correctamente






-----Menu de tareas----
1. Crear Tareas
2. Ver Tareas
3. Eliminar Tarea
4. Actualizar Tarea
5. Clonar Tarea
6. Marcar Tarea como completada
7. Salir
Selecciona tu opcion: 3




----_Eliminar Tarea_----
ID: 2 | Titulo: Evaluacion de patrones de dise?o  | Descripcion: Evaluacion numero 3 de patrones de dise?o | Fecha: 27 de junio del 2025 | Prioridad: 3 | Completada: Si
Ingrese el Id de la tarea a eliminar:
2
Tarea eliminada correctamente

```

