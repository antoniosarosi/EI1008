package tests.Apuntes.EstructuraDatos;

import static org.junit.Assert.*;

import Apuntes.EstructuraDatos.Listas.LinkedList.DoublyLinkedList;
import org.junit.Before;
import org.junit.Test;


public class ListaTest {

    private DoublyLinkedList lista1, lista2, lista3, lista4, lista5, lista6, lista7, lista8, lista9;

    @Before
    public void setUp() {
        lista1 = new DoublyLinkedList();
        lista2 = new DoublyLinkedList(1);
        lista3 = new DoublyLinkedList(new int[] {1, 2, 3});
        lista4 = new DoublyLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        lista5 = new DoublyLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        lista6 = new DoublyLinkedList(new int[] {1, 2, 3, 4, 1, 1, 1, 5, 6, 7, 1, 1, 1});
        lista7 = new DoublyLinkedList(new int[] {1, 2, 3});
        lista8 = new DoublyLinkedList(new int[] {1, 2, 3, 4, 5, 9});
        lista9 = new DoublyLinkedList(new int[] {0, 0, 0, 2, 3, 4, 0, 0, 0, 0, 0, 5, 6, 7, 8, 0, 0, 0, 0, 0});
    }

    @Test
    public void testConstructores() {
        assertEquals("El constructor de lista vacía falla en crear una lista vacía",
                "[]", lista1.toString());
        assertEquals("El constructor de lista vacía falla en asignar bien el espacio ocupado",
                0, lista1.length());

        assertEquals("El constructor de un solo dato falla en asignar el dato a la lista",
                "[1]", lista2.toString());
        assertEquals("El constructor de un solo dato falla en asignar bien el espacio ocupado",
                1, lista2.length());

        assertEquals("El constructor a partir de array falla en asignar los datos a la lista",
                "[1, 2, 3]", lista3.toString());
        assertEquals("El constructor a partir de array falla en asignar bien el espacio ocupado",
                3, lista3.length());
    }

    @Test
    public void appendTest() {
        lista1.append(9);
        lista2.append(9);
        lista3.append(9);

        assertEquals("append falla al añadir el elemento  una lista vacía",
                "[9]", lista1.toString());
        assertEquals("append falla al asignar bien el espacio ocupado", 1, lista1.length());

        assertEquals("append falla al añadir el elemento  una lista con un solo elemento",
                "[1, 9]", lista2.toString());
        assertEquals("append falla al asignar bien el espacio ocupado", 2, lista2.length());

        assertEquals("append falla al añadir el elemento  una lista con varios elementos",
                "[1, 2, 3, 9]", lista3.toString());
        assertEquals("append falla al asignar bien el espacio ocupado", 4, lista3.length());
    }

    @Test
    public void insertTest() {

        lista4.insert(0, 0);
        assertEquals("insert falla si hay que añadir un elemento a la posicion 0",
                "[0, 1, 2, 3, 4, 5, 6, 7, 8]", lista4.toString());

        lista4.insert(9, 9);
        assertEquals("insert falla si hay que añadir un elemento despues de la ultima posicion",
                "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", lista4.toString());

        lista4.insert(9, 11);
        assertEquals("insert falla si hay que añadir un elemento justo en la posicion del ultimo",
                "[0, 1, 2, 3, 4, 5, 6, 7, 8, 11, 9]", lista4.toString());

        lista4.insert(4, 12);
        assertEquals("insert falla si hay que añadir un elemento en medio",
                "[0, 1, 2, 3, 12, 4, 5, 6, 7, 8, 11, 9]", lista4.toString());
    }

    @Test
    public void deleteIndexTest() {

        lista5.deleteIndex(0);
        assertEquals("deleteIndex Falla si borramos el primer elemento", "[2, 3, 4, 5, 6, 7, 8]",
                lista5.toString());
        assertEquals("deleteIndex falla al asignar el espacio ocupado", 7, lista5.length());

        lista5.deleteIndex(6);
        assertEquals("deleteIndex Falla si borramos el ultimo elemento", "[2, 3, 4, 5, 6, 7]",
                lista5.toString());
        assertEquals("deleteIndex falla al asignar el espacio ocupado", 6, lista5.length());

        lista5.deleteIndex(3);
        assertEquals("deleteIndex Falla si borramos un elemento del medio", "[2, 3, 4, 6, 7]",
                lista5.toString());
        assertEquals("deleteIndex falla al asignar el espacio ocupado", 5, lista5.length());
    }

    @Test
    public void deleteLastTest() {
        lista3.deleteLast();
        assertEquals("delteLast falla", "[1, 2]", lista3.toString());
        lista3.deleteLast();
        assertEquals("delteLast falla", "[1]", lista3.toString());
    }

    @Test(timeout = 100)
    public void delFirstEncounter() {
        String expected = "[1, 2, 4, 5, 9]";
        lista8.delElement(3);
        assertEquals("delFirstEncouner falla", expected, lista8.toString());

        String expected2 = "[2, 4, 5, 9]";
        lista8.delElement(1);
        assertEquals("delFirstEncouner falla", expected2, lista8.toString());

        String expected3 = "[2, 4, 5]";
        lista8.delElement(9);
        assertEquals("delFirstEncouner falla", expected3, lista8.toString());

        assertFalse("delFirstEncouner falla", lista8.delElement(12));
    }

    @Test
    public void deleteAllTest() {

        String expected = "[2, 3, 4, 5, 6, 7]";
        lista6.delAllElements(1);
        assertEquals("delAllElements falla", expected, lista6.toString());


        String expected2 = "[2, 3]";
        lista7.delAllElements(1);
        assertEquals("delAllElements falla", expected2, lista7.toString());

        String expected3 = "[1, 2, 3, 4, 5]";
        lista8.delAllElements(9);
        assertEquals("delAllElements falla", expected3, lista8.toString());

        String expected4 = "[2, 3, 4, 5, 6, 7, 8]";
        lista9.delAllElements(0);
        assertEquals("delAllElements falla", expected4, lista9.toString());
    }

}