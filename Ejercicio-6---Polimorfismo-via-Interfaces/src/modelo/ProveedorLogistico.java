package modelo;

public class ProveedorLogistico extends ApiExterna implements Documentable, Auditable {
    public ProveedorLogistico(String id, String nombre, int latenciaPromedio) {
        super(id, nombre, latenciaPromedio);
    }

    @Override
    public String generarDocumento(String referencia) {
        return "Guia de envio creada para " + referencia + " en " + getNombre();
    }

    @Override
    public String registrarAuditoria(String operacion) {
        return "Auditoria registrada: " + operacion + " en " + getNombre();
    }

    @Override
    protected String getTipo() {
        return "Proveedor logistico";
    }
}
