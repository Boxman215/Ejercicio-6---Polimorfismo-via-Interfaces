package modelo;

public class BilleteraDigital extends ApiExterna implements Transaccional, Auditable {
    public BilleteraDigital(String id, String nombre, int latenciaPromedio) {
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
        return "Billetera digital";
    }
}
