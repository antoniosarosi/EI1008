package tests.Apuntes.EstructuraDatos.ColasTests;

import static org.junit.Assert.*;
import org.junit.Test;

import Apuntes.EstructuraDatos.Colas.ColaNodoDoble;
import java.util.Arrays;

public class ColaDobleTest {

    private ColaNodoDoble cola1 = new ColaNodoDoble(), cola2 = new ColaNodoDoble(1),
            cola3 = new ColaNodoDoble(new int[] {1, 2, 3});

    @Test
    public void constructorsTest() {
        assertEquals("el constructor vacio falla", "[]", cola1.toString());
        assertEquals("el constructor de elemento falla", "[1]", cola2.toString());
        assertEquals("el constructor de array falla", "[1, 2, 3]", cola3.toString());

    }

    @Test
    public void addTest() {
        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] v2 = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i : v) cola1.addL(i);
        assertEquals("addL falla si cola vacia", Arrays.toString(v), cola1.toString());

        for (int i = 1; i < v.length; i++) cola2.addL(v[i]);
        assertEquals("addL falla si cola tiene un elemento", Arrays.toString(v), cola2.toString());

        for (int i = 3; i < v.length; i++) cola3.addL(v[i]);
        assertEquals("addL falla si cola tiene varios elementos", Arrays.toString(v), cola3.toString());

        for (int i = 0; i >= -10; i--) cola1.addF(i);
            assertEquals("addF falla", Arrays.toString(v2), cola1.toString());
    }

    @Test
    public void peekTest() {
        assertEquals("peekL falla si solo hay un elemento", 1, cola2.peekL());
        assertEquals("peekL falla si hay más de un elemento", 3, cola3.peekL());

        assertEquals("peekF falla si solo hay un elemento", 1, cola2.peekF());
        assertEquals("peekF falla si hay más de un elemento", 1, cola3.peekF());
    }

    @Test
    public void pollTest() {
        assertEquals("pollL falla si solo hay un elemento", 1, cola2.pollL());
        assertEquals("pollL falla si hay más de un elemento", 3, cola3.pollL());

        assertEquals("pollL falla en eliminar el primero si solo hay un elemento", "[]", cola2.toString());
        assertEquals("pollL falla en eliminar el primero si hay más de un elemento", "[1, 2]", cola3.toString());

        int[] v = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : v) cola1.addL(i);
        for (int i = v.length - 1; i >= 0; i--)
            assertEquals("pollL falla al eliminar varios elementos", v[i], cola1.pollL());

        for (int i : v) cola1.addL(i);
        for (int i = v.length - 1; i >= 0; i--)
            assertEquals("pollF falla al eliminar varios elementos", v[i], cola1.pollL());
    }

    @Test(timeout = 10000)
    public void timeTest() {
        int a;
        for (int i = 1; i <= 100000; i++) cola1.addL(i);
        for (int i = 1; i <= 100000; i++) a = cola1.pollL();

        int b;
        for (int i = 1; i <= 100000; i++) cola1.addF(i);
        for (int i = 1; i <= 100000; i++) b = cola1.pollL();
    }
}
