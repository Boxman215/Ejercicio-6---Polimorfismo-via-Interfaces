package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoIntegraciones {
    private final List<Integracion> integraciones = new ArrayList<>();

    public void agregar(Integracion integracion) {
        integraciones.add(integracion);
    }

    public void agregar(Integracion... nuevasIntegraciones) {
        for (Integracion integracion : nuevasIntegraciones) {
            agregar(integracion);
        }
    }

    public List<Integracion> listar() {
        return Collections.unmodifiableList(integraciones);
    }

    public Integracion buscar(String id) {
        for (Integracion integracion : integraciones) {
            if (integracion.getId().equalsIgnoreCase(id)) {
                return integracion;
            }
        }
        return null;
    }

    public void ordenarPorLatencia() {
        Collections.sort(integraciones);
    }
}
