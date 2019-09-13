package tests.Apuntes.EstructuraDatos;

import static org.junit.Assert.*;
import org.junit.Test;

import Apuntes.EstructuraDatos.Stacks.StackNodes;

public class StackTest {

    private StackNodes stack1 = new StackNodes(),
            stack2 = new StackNodes(1), stack3 = new StackNodes(new int[] {1, 2, 3});

    @Test
    public void ConstructorsTest() {
        assertEquals("Constructor de pila vacía falla", "[]", stack1.toString());
        assertEquals("Constructor de pila con un elemento falla", "[1]", stack2.toString());
        assertEquals("Constructor de pila con array falla", "[3, 2, 1]", stack3.toString());
    }

    @Test
    public void pushTest() {
        for (int i = 1; i <= 10; i++) stack1.push(i);
        assertEquals("push falla con pila vacía", "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]", stack1.toString());

        for (int i = 2; i <= 10; i++) stack2.push(i);
        assertEquals("push falla con pila de 1 elemento", "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]", stack2.toString());

        for (int i = 4; i <= 10; i++) stack3.push(i);
        assertEquals("push falla con pila de varios elementos", "[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]", stack3.toString());
    }

    @Test
    public void popTest() {
        for (int i = 1; i <= 10; i++) stack1.push(i);
        for (int i = 10; i >= 1; i--) assertEquals("pop falla", i, stack1.pop());
    }

    @Test(timeout = 15000)
    public void timeTest() {
        int e;
        for (int i = 0; i < 10000000; i++) stack1.push(i);
        for (int i = 0; i < 10000000; i++) e = stack1.pop();
    }
}
