package modelo;

public class CertificadorFEL extends ApiExterna implements Documentable, Auditable {
    public CertificadorFEL(String id, String nombre, int latenciaPromedio) {
        super(id, nombre, latenciaPromedio);
    }

    @Override
    public String generarDocumento(String referencia) {
        return "Factura FEL generada para " + referencia + " en " + getNombre();
    }

    @Override
    public String registrarAuditoria(String operacion) {
        return "Auditoria registrada: " + operacion + " en " + getNombre();
    }

    @Override
    protected String getTipo() {
        return "Certificador FEL";
    }
}
