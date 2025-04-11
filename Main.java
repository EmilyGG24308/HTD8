//Interaction with user

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Seleccione la implementación de PriorityQueue:");
            System.out.println("1. VectorHeap");
            System.out.println("2. PriorityQueue");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                VectorHeap<Paciente> cola = new VectorHeap<>();
                EmergencyThing.cargarPacientesDesdeArchivo(cola);
                EmergencyThing.atenderPacientes(cola);

            } else if (opcion == 2) {
                java.util.PriorityQueue<Paciente> cola = new java.util.PriorityQueue<>();
                EmergencyThing.cargarPacientesDesdeArchivo(cola::add);
                System.out.println("\nOrden de atención:");
                while (!cola.isEmpty()) {
                    System.out.println(cola.remove());
                }
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
