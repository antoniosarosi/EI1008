package Apuntes.EstructuraDatos.Listas.ArrayList;

import Apuntes.EstructuraDatos.Listas.ListaInt;
import java.util.NoSuchElementException;

public class ListaArray implements ListaInt {

    private int occupiedSpace;
    private Integer[] array;

    public ListaArray() {
        // Construye una lista vacía
        occupiedSpace = 0;
        array = new Integer[10];
    }

    public ListaArray(int data) {
        // Construye una lista con un elemento dado
        occupiedSpace = 1;
        array = new Integer[10];
        array[0] = data;
    }

    public ListaArray(int[] v) {
        // Construye una lista a partir de un array dado
        occupiedSpace = v.length;
        if (v.length == 0) array = new Integer[10];
        else if (v.length >= 10) array = new Integer[v.length * 2];
        else array = new Integer[10];
        for (int i = 0; i < v.length; i++) array[i] = v[i];
    }

    public int length() {
        // Devuelve el length de la lista, esto es, el length de la lista contenida en el atributo array
        return occupiedSpace;
    }

    public void append(int data) {
        // Añade elemento al final de la lista
        adjustCapacity(1);
        array[occupiedSpace] = data;
        occupiedSpace++;
    }

    public void insert(int posicion, int data) {
        // Inserta un elemento en la posicion indicada
        if (occupiedSpace == 0) throw new IndexOutOfBoundsException();
        if (posicion < 0 || posicion > occupiedSpace) throw new IndexOutOfBoundsException();
        adjustCapacity(1);
        shiftRight(posicion);
        array[posicion] = data;
        occupiedSpace++;
    }

    public int get(int posicion) {
        checkPosition(posicion);
        return array[posicion];
    }

    public void set(int posicion, int data) {
        checkPosition(posicion);
        array[posicion] = data;
    }

    public void deleteIndex(int posicion) {
        // Elimina la posicion indicada
        checkPosition(posicion);
        shiftLeft(posicion + 1);
        adjustCapacity(-1);
        occupiedSpace--;
    }

    public void clearList() {
        // Elimina toda la lista
        occupiedSpace = 0;
        array = new Integer[10];
    }

    public void deleteLast() {
        // Elimina el último elemento de la lista
        shiftLeft(occupiedSpace);
        adjustCapacity(-1);
        occupiedSpace--;
    }

    public boolean delElement(int elemento) {
        // Elimina la primera aparicion de elemento
        if (occupiedSpace == 0) throw new NoSuchElementException();
        for (int i = 0; i < occupiedSpace; i++)
            if (array[i] == elemento) {
                shiftLeft(i + 1);
                adjustCapacity(-1);
                occupiedSpace--;
                return true;
            }
        return false;
    }

    public boolean delAllElements(int elemento) {
        // Elimina todas las apariciones de elemento
        if (occupiedSpace == 0) throw new NoSuchElementException();

        boolean deleted = false;
        int i = 0, numDeleted = 0;
        while (i < occupiedSpace && array[i] != null) {
            if (array[i] == elemento) {
                shiftLeft(i + 1);
                numDeleted--;
                i--;
                deleted = true;
            }
            i++;
        }
        adjustCapacity(numDeleted);
        occupiedSpace += numDeleted;
        return deleted;
    }

    @Override
    public String toString() {
        if (occupiedSpace == 0) return "[]";

        String cadena = "[";
        cadena += array[0];
        for (int i = 1; i < occupiedSpace; i++)
            cadena += ", " + array[i];

        return cadena + "]";
    }

    private void checkPosition(int posicion) {
        if (occupiedSpace == 0) throw new IndexOutOfBoundsException();
        if (posicion < 0 || posicion >= occupiedSpace) throw new IndexOutOfBoundsException();
    }

    private void adjustCapacity(int numOfElements) {
        // numOfElements: número de elementos que van a entrar o han salido del array, si salen es negativo

        /* Ajusta el tamaño del array para contener el subarray que consideramos como lista, si el espacio
         * ocupado llega a superar el length del array, duplicamos el array, si el espacio ocupado se reduce
         * a un cuarto del tamaño del array, reducimos este tamaño a la mitad. */

        Integer[] newArray = new Integer[0];

        if (occupiedSpace + numOfElements > array.length)
            newArray = new Integer[array.length * 2];

        else if (array.length / 2 >= 10)
            if (occupiedSpace + numOfElements <= array.length / 4) {
                newArray = new Integer[array.length];
                do newArray = new Integer[newArray.length / 2];
                while (occupiedSpace + numOfElements <= newArray.length / 4 && newArray.length >= 20);
            }

        if (newArray.length != 0) {
            for (int i = 0; i < occupiedSpace; i++)
                newArray[i] = array[i];

            array = newArray;
        }
    }

    private void shiftRight(int shiftInitializePosition) {
        // Desplaza a la derecha en un solo slot los elementos a partir de la posicion dada
        for (int i = occupiedSpace - 1; i >= shiftInitializePosition; i--)
            array[i + 1] = array[i];
    }

    private void shiftLeft(int shiftInitializePosition) {
        // Desplaza a la izquierda los elementos en un solo slot a partir de la posicion dada
        for (int i = shiftInitializePosition; i < occupiedSpace; i++)
            array[i - 1] = array[i];
        // Hay que poner a null el ultimo elemento, si no quedará como copia
        array[occupiedSpace - 1] = null;
    }

}
