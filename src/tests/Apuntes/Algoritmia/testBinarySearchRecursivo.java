package tests.Apuntes.Algoritmia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static Apuntes.Algoritmia.SearchAlgorithms.*;

public class testBinarySearchRecursivo {

    private int[] v;

    @Before
    public void setUp() {
        v = new int[] {1, 3, 7, 10, 15, 20, 30};
    }

    @Test(timeout = 100)
    public void testBinarySearch() {
        assertEquals("Mitad derecha", busquedaBinaria(v, 20), recursiveBinarySearch(v, 20));
        assertEquals("Mitad izquierda", busquedaBinaria(v, 3), recursiveBinarySearch(v, 3));
        assertEquals("Medio", busquedaBinaria(v, 10), recursiveBinarySearch(v, 10));
        assertEquals("Extremo izquierda", busquedaBinaria(v, 1), recursiveBinarySearch(v, 1));
        assertEquals("Mitad derecha", busquedaBinaria(v, 30), recursiveBinarySearch(v, 30));
        assertEquals("No esta (izq)", busquedaBinaria(v, 0), recursiveBinarySearch(v, 0));
        assertEquals("No esta (dcha)", busquedaBinaria(v, 35), recursiveBinarySearch(v, 35));
    }
}
