import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Consumer;

public class EmergencyThing {

    public static void cargarPacientesDesdeArchivo(PriorityQueue<Paciente> cola) {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                String sintoma = partes[1].trim();
                char prioridad = partes[2].trim().charAt(0);
              //add new patient
                cola.add(new Paciente(nombre, sintoma, prioridad));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void cargarPacientesDesdeArchivo(Consumer<Paciente> consumer) {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                String sintoma = partes[1].trim();
                char prioridad = partes[2].trim().charAt(0);
                consumer.accept(new Paciente(nombre, sintoma, prioridad));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void atenderPacientes(PriorityQueue<Paciente> cola) {
        System.out.println("\nOrden de atención:");
        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }
}
