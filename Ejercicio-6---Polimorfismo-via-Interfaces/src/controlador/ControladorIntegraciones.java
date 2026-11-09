package controlador;

import modelo.Auditable;
import modelo.BilleteraDigital;
import modelo.CatalogoIntegraciones;
import modelo.CertificadorFEL;
import modelo.Documentable;
import modelo.Integracion;
import modelo.PasarelaPago;
import modelo.ProveedorLogistico;
import modelo.Transaccional;
import vista.VistaConsola;

public class ControladorIntegraciones {
    private final CatalogoIntegraciones catalogo = new CatalogoIntegraciones();
    private final VistaConsola vista = new VistaConsola();

    public void iniciar() {
        cargarIntegraciones();
        boolean continuar = true;
        while (continuar) {
            switch (vista.mostrarMenu()) {
                case 1 -> listar();
                case 2 -> buscar();
                case 3 -> ordenar();
                case 4 -> operar();
                case 0 -> continuar = false;
                default -> vista.mostrar("Opcion no valida.");
            }
        }
        vista.mostrar("Programa finalizado.");
    }

    private void cargarIntegraciones() {
        catalogo.agregar(
                new PasarelaPago("P-001", "VisaPay", 120),
                new PasarelaPago("P-002", "MasterCard", 160),
                new PasarelaPago("P-003", "PayFast", 95),
                new BilleteraDigital("B-001", "Maya Wallet", 80),
                new BilleteraDigital("B-002", "WalletGo", 110),
                new ProveedorLogistico("L-001", "Envio Rapido", 240),
                new ProveedorLogistico("L-002", "Carga Ya", 180),
                new ProveedorLogistico("L-003", "Ultima Milla", 210),
                new CertificadorFEL("F-001", "FEL Guatemala", 140),
                new CertificadorFEL("F-002", "Factura Now", 130)
        );
    }

    private void listar() {
        for (Integracion integracion : catalogo.listar()) {
            vista.mostrar(integracion.toString());
        }
    }

    private void buscar() {
        Integracion integracion = catalogo.buscar(vista.leerTexto("Id: "));
        vista.mostrar(integracion == null ? "No se encontro la integracion." : integracion.toString());
    }

    private void ordenar() {
        catalogo.ordenarPorLatencia();
        vista.mostrar("Catalogo ordenado por latencia:");
        listar();
    }

    private void operar() {
        Integracion integracion = catalogo.buscar(vista.leerTexto("Id: "));
        if (integracion == null) {
            vista.mostrar("No se encontro la integracion.");
            return;
        }

        int opcion = vista.mostrarMenuOperacion();
        if (opcion == 1 || opcion == 2) {
            procesarTransaccion(integracion, opcion);
        } else if (opcion == 3) {
            procesarDocumento(integracion);
        } else if (opcion == 4) {
            procesarAuditoria(integracion);
        } else {
            vista.mostrar("Operacion no valida.");
        }
    }

    private void procesarTransaccion(Integracion integracion, int opcion) {
        if (!(integracion instanceof Transaccional)) {
            vista.mostrar("La integracion no permite operaciones financieras. Solicitud ignorada.");
            return;
        }
        Transaccional transaccional = (Transaccional) integracion;
        double monto = vista.leerMonto();
        vista.mostrar(opcion == 1 ? transaccional.cobrar(monto) : transaccional.reintegrar(monto));
    }

    private void procesarDocumento(Integracion integracion) {
        if (!(integracion instanceof Documentable)) {
            vista.mostrar("La integracion no genera documentos.");
            return;
        }
        Documentable documentable = (Documentable) integracion;
        vista.mostrar(documentable.generarDocumento(vista.leerTexto("Referencia: ")));
    }

    private void procesarAuditoria(Integracion integracion) {
        if (!(integracion instanceof Auditable)) {
            vista.mostrar("La integracion no permite auditoria.");
            return;
        }
        Auditable auditable = (Auditable) integracion;
        vista.mostrar(auditable.registrarAuditoria(vista.leerTexto("Operacion: ")));
    }
}
