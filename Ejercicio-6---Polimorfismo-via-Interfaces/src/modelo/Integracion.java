package modelo;

public interface Integracion extends Comparable<Integracion> {
    String getId();
    String getNombre();
    int getLatenciaPromedio();
    String consultarEstado();
}
