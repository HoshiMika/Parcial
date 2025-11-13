import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GrafoEstudiantes grafo = new GrafoEstudiantes();

        
        String archivoCSV = "parcial_estudiantes.csv";

        
        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;
                String[] datos = linea.split(",");
                if (datos.length < 3) {
                    System.err.println("Línea inválida (se esperan 3 columnas): " + linea);
                    continue;
                }
                String nombre = datos[0].trim();
                int codigo;
                double promedio;
                try {
                    codigo = Integer.parseInt(datos[1].trim());
                    promedio = Double.parseDouble(datos[2].trim());
                } catch (NumberFormatException nfe) {
                    System.err.println("Error numérico en línea: " + linea);
                    continue;
                }
                grafo.agregarEstudiante(new Estudiante(nombre, codigo, promedio));
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo CSV: " + e.getMessage());
        }

        grafo.agregarRelacion("Ana Garcia", "Carlos Ruiz");
        grafo.agregarRelacion("Carlos Ruiz", "Diego Lopez");
        grafo.agregarRelacion("Diego Lopez", "Elena Martinez");
        grafo.agregarRelacion("Elena Martinez", "Fernando Perez");
        grafo.agregarRelacion("Fernando Perez", "Gabriela Torres");
        grafo.agregarRelacion("Gabriela Torres", "Hector Diaz");
        grafo.agregarRelacion("Hector Diaz", "Isabel Gomez");
        grafo.agregarRelacion("Isabel Gomez", "Julian Castro");
        grafo.agregarRelacion("Julian Castro", "Karina Silva");

        System.out.println("Lista inicial de estudiantes:");
        grafo.mostrarEstudiantes();
        System.out.println();

        grafo.agregarEstudiante(new Estudiante("Luisa Fernandez", 111, 4.6));
        grafo.agregarEstudiante(new Estudiante("Manuel Ortiz", 112, 4.7));

        
        grafo.eliminarEstudiante("Hector Diaz");
        grafo.eliminarEstudiante("Karina Silva");

        
        grafo.agregarRelacion("Luisa Fernandez", "Manuel Ortiz");

        
        grafo.eliminarRelacion("Hector Diaz", "Isabel Gomez");
        grafo.eliminarRelacion("Julian Castro", "Karina Silva");

        System.out.println("Relaciones actuales de Ana Garcia:");
        grafo.mostrarRelaciones("Ana Garcia");
        System.out.println();

        System.out.println("Relaciones actuales de Luisa Fernandez:");
        grafo.mostrarRelaciones("Luisa Fernandez");
        System.out.println();

        System.out.println("Lista final de estudiantes:");
        grafo.mostrarEstudiantes();
    }
}
