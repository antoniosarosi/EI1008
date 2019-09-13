package tests.Apuntes.EstructuraDatos.ColasTests;

import static org.junit.Assert.*;

import Apuntes.EstructuraDatos.Colas.ColaNodoSimple;
import org.junit.Test;

import java.util.Arrays;

public class ColaSimpleTest {

    private ColaNodoSimple cola1 = new ColaNodoSimple(), cola2 = new ColaNodoSimple(1),
            cola3 = new ColaNodoSimple(new int[] {1, 2, 3});

    @Test
    public void constructorsTest() {
        assertEquals("el constructor vacio falla", "[]", cola1.toString());
        assertEquals("el constructor de elemento falla", "[1]", cola2.toString());
        assertEquals("el constructor de array falla", "[1, 2, 3]", cola3.toString());

    }

    @Test
    public void addTest() {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i : v) cola1.add(i);
        assertEquals("add falla si cola vacia", Arrays.toString(v), cola1.toString());

        for (int i = 1; i < v.length; i++) cola2.add(v[i]);
        assertEquals("add falla si cola tiene un elemento", Arrays.toString(v), cola2.toString());

        for (int i = 3; i < v.length; i++) cola3.add(v[i]);
        assertEquals("add falla si cola tiene varios elementos", Arrays.toString(v), cola3.toString());
    }

    @Test
    public void peekTest() {
        assertEquals("peek falla si solo hay un elemento", 1, cola2.peek());
        assertEquals("peek falla si hay más de un elemento", 1, cola3.peek());
    }

    @Test
    public void pollTest() {
        assertEquals("poll falla si solo hay un elemento", 1, cola2.poll());
        assertEquals("poll falla si hay más de un elemento", 1, cola3.poll());

        assertEquals("poll falla en eliminar el primero si solo hay un elemento", "[]", cola2.toString());
        assertEquals("poll falla en eliminar el primero si hay más de un elemento", "[2, 3]", cola3.toString());

        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : v) cola1.add(i);
        for (int i : v) assertEquals("poll falla al eliminar varios elementos", i, cola1.poll());
    }

    @Test(timeout = 10000)
    public void timeTest() {
        int e;
        for (int i = 1; i <= 100000; i++) cola1.add(i);
        for (int i = 1; i <= 100000; i++) e = cola1.poll();
    }
}