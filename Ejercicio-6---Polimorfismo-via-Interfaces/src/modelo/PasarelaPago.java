package modelo;

public class PasarelaPago extends ApiExterna implements Transaccional, Auditable {
    public PasarelaPago(String id, String nombre, int latenciaPromedio) {
        super(id, nombre, latenciaPromedio);
    }

    @Override
    public String cobrar(double monto) {
        return "Cobro aprobado por Q" + String.format("%.2f", monto) + " en " + getNombre();
    }

    @Override
    public String reintegrar(double monto) {
        return "Reintegro aprobado por Q" + String.format("%.2f", monto) + " en " + getNombre();
    }

    @Override
    public String registrarAuditoria(String operacion) {
        return "Auditoria registrada: " + operacion + " en " + getNombre();
    }

    @Override
    protected String getTipo() {
        return "Pasarela de pago";
    }
}
