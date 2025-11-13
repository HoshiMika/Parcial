import java.util.*;

public class GrafoEstudiantes {
    private Map<String, Estudiante> estudiantes;
    private Map<String, Set<String>> relaciones; 

    public GrafoEstudiantes() {
        estudiantes = new LinkedHashMap<>(); 
        relaciones = new HashMap<>();
    }

    
    public void agregarEstudiante(Estudiante e) {
        if (e == null || e.getNombre() == null) return;
        String nombre = e.getNombre();
        if (!estudiantes.containsKey(nombre)) {
            estudiantes.put(nombre, e);
            relaciones.putIfAbsent(nombre, new LinkedHashSet<>());
        } else {
            
            estudiantes.put(nombre, e);
        }
    }

    
    public void eliminarEstudiante(String nombre) {
        if (nombre == null) return;
        if (!estudiantes.containsKey(nombre)) {
            System.out.println("Advertencia: no existe el estudiante: " + nombre);
            return;
        }
        estudiantes.remove(nombre);
        relaciones.remove(nombre);
        for (Set<String> amigos : relaciones.values()) {
            amigos.remove(nombre);
        }
    }

    
    public void agregarRelacion(String e1, String e2) {
        if (e1 == null || e2 == null) return;
        if (!estudiantes.containsKey(e1)) {
            System.out.println("Advertencia: estudiante no encontrado: " + e1);
            return;
        }
        if (!estudiantes.containsKey(e2)) {
            System.out.println("Advertencia: estudiante no encontrado: " + e2);
            return;
        }
        relaciones.putIfAbsent(e1, new LinkedHashSet<>());
        relaciones.putIfAbsent(e2, new LinkedHashSet<>());
        relaciones.get(e1).add(e2);
        relaciones.get(e2).add(e1);
    }

    
    public void eliminarRelacion(String e1, String e2) {
        if (e1 == null || e2 == null) return;
        if (relaciones.containsKey(e1)) relaciones.get(e1).remove(e2);
        if (relaciones.containsKey(e2)) relaciones.get(e2).remove(e1);
    }

    
    public void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el grafo.");
            return;
        }
        for (Estudiante e : estudiantes.values()) {
            System.out.println(e);
        }
    }

    
    public Estudiante buscarEstudiante(String nombre) {
        return estudiantes.get(nombre);
    }

    
    public void mostrarRelaciones(String nombre) {
        if (!relaciones.containsKey(nombre)) {
            System.out.println("Estudiante no encontrado o sin relaciones: " + nombre);
            return;
        }
        Set<String> amigos = relaciones.get(nombre);
        if (amigos.isEmpty()) {
            System.out.println("El estudiante '" + nombre + "' no tiene relaciones registradas.");
        } else {
            System.out.println("Relaciones de " + nombre + ":");
            for (String a : amigos) {
                System.out.println(" - " + a);
            }
        }
    }
}
