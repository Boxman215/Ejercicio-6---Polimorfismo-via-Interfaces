package modelo;

public abstract class ApiExterna implements Integracion {
    private final String id;
    private final String nombre;
    private final int latenciaPromedio;

    protected ApiExterna(String id, String nombre) {
        this(id, nombre, 100);
    }

    protected ApiExterna(String id, String nombre, int latenciaPromedio) {
        this.id = id;
        this.nombre = nombre;
        this.latenciaPromedio = latenciaPromedio;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getLatenciaPromedio() {
        return latenciaPromedio;
    }

    @Override
    public String consultarEstado() {
        return "Activa";
    }

    @Override
    public int compareTo(Integracion otra) {
        return Integer.compare(latenciaPromedio, otra.getLatenciaPromedio());
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + getTipo() + " | " + latenciaPromedio + " ms | " + consultarEstado();
    }

    protected abstract String getTipo();
}
