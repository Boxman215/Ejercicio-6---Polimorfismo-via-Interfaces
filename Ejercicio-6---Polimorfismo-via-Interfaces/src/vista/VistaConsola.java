package vista;

import java.util.Scanner;

public class VistaConsola {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== Catalogo de integraciones ===");
        System.out.println("1. Listar integraciones");
        System.out.println("2. Buscar integracion");
        System.out.println("3. Ordenar por latencia");
        System.out.println("4. Ejecutar operacion");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }

    public int mostrarMenuOperacion() {
        System.out.println("\n1. Cobrar");
        System.out.println("2. Reintegrar");
        System.out.println("3. Generar documento");
        System.out.println("4. Registrar auditoria");
        System.out.print("Operacion: ");
        return scanner.nextInt();
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public double leerMonto() {
        System.out.print("Monto: Q");
        return scanner.nextDouble();
    }

    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}
