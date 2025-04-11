import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VectorHeapTest {

    private VectorHeap<Paciente> heap;

    @BeforeEach
    public void setUp() {
        heap = new VectorHeap<>();
    }

    // metodo compareTo (Paciente)
    @Test
    public void testPacienteComparison() {
        Paciente paciente1 = new Paciente("Juan", "Nariz Fracturado", 'B');
        Paciente paciente2 = new Paciente("Maria", "Derrame cerebral", 'A');
        Paciente paciente3 = new Paciente("Pedro", "Dolor de Cabeza con fiebre alta", 'C');

        assertTrue(paciente1.compareTo(paciente2) > 0, "Paciente1 debería tener una prioridad más baja que Paciente2");
        assertTrue(paciente2.compareTo(paciente3) < 0, "Paciente2 debería tener una prioridad más alta que Paciente3");
        assertEquals(0, paciente1.compareTo(paciente1), "Comparando el mismo paciente debería retornar 0");
    }

    //metodo toString (Paciente)
    @Test
    public void testPacienteToString() {
        Paciente paciente = new Paciente("Juan", "Nariz Fracturado", 'B');
        String expected = "Juan, Nariz Fracturado, B";
        assertEquals(expected, paciente.toString(), "El método toString() debería devolver el formato correcto");
    }

    //Add and delete patients
    @Test
    public void testAddAndRemovePaciente() {
        Paciente paciente1 = new Paciente("Juan", "Nariz Fracturado", 'B');
        Paciente paciente2 = new Paciente("Maria", "Derrame cerebral", 'A');
        Paciente paciente3 = new Paciente("Pedro", "Dolor de Cabeza con fiebre alta", 'C');

        heap.add(paciente1);
        heap.add(paciente2);
        heap.add(paciente3);

        // Verificamos el orden de eliminación (basado en la prioridad, 'A' debería salir primero)
        assertEquals(paciente2, heap.remove(), "El paciente con mayor prioridad (A) debería ser eliminado primero");
        assertEquals(paciente1, heap.remove(), "El paciente con la siguiente prioridad (B) debería ser eliminado segundo");
        assertEquals(paciente3, heap.remove(), "El paciente con la prioridad más baja (C) debería ser eliminado último");
    }

    // Prueba para eliminar de un heap vacío
    @Test
    public void testRemoveFromEmptyHeap() {
        assertNull(heap.remove(), "Eliminar de un heap vacío debería devolver null");
    }

    //add and eliminar just one patient
    @Test
    public void testAddRemoveSingleElement() {
        Paciente paciente = new Paciente("Juan", "Nariz Fracturado", 'B');
        heap.add(paciente);
        assertEquals(paciente, heap.remove(), "Eliminar el único elemento debería devolver ese elemento");
    }

    //check if empty
    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty(), "El heap debería estar vacío inicialmente");

        heap.add(new Paciente("Juan", "Nariz Fracturado", 'B'));
        assertFalse(heap.isEmpty(), "El heap no debería estar vacío después de agregar un elemento");

        heap.remove();
        assertTrue(heap.isEmpty(), "El heap debería estar vacío después de eliminar el único elemento");
    }
}
