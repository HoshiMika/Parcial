public class Estudiante {
    private String nombre;
    private int codigo;
    private double promedio;

    public Estudiante(String nombre, int codigo, double promedio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return String.format("%s (Código: %d, Promedio: %.2f)", nombre, codigo, promedio);
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante e = (Estudiante) o;
        return nombre != null && nombre.equals(e.nombre);
    }

    @Override
    public int hashCode() {
        return nombre == null ? 0 : nombre.hashCode();
    }
}
