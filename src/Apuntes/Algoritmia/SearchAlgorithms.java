package Apuntes.Algoritmia;

public class SearchAlgorithms {

    private static int sequentialSearch(int[] v, int key) {
        for (int i = 0; i < v.length; i++)
            if (v[i] == key)
                return i;
        return -1;
    }

    public static int sequentialSearch(int[] v, boolean sorted, int key) {
        if (! sorted)
            return sequentialSearch(v, key);
        for (int i = 0; i < v.length; i++)
            if (v[i] == key)
                return i;
            else if (v[i] > key)
                return -1;

        return -1;
    }

    public static int busquedaBinaria(int[] v, int buscado) {
        int inicio = 0;
        int fin = v.length - 1;
        while (inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            if (v[mitad] > buscado)
                fin = mitad - 1;
            else if (v[mitad] < buscado)
                inicio = mitad + 1;
            else
                return mitad;
        }
        return -inicio - 1;
    }

    private static int recursiveBinarySearch(int[] v, int key, int start, int end) {
        if (start > end)
            return -start - 1;
        int middle = (start + end) / 2;
        if (v[middle] < key)
            return recursiveBinarySearch(v, key, middle + 1, end);
        else if (v[middle] > key)
            return recursiveBinarySearch(v, key, start, middle - 1);
        else
            return middle;
    }

    public static int recursiveBinarySearch(int[] v, int key) {
        return recursiveBinarySearch(v, key, 0, v.length - 1);
    }
}
