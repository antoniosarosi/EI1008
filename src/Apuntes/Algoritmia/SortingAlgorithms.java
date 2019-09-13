package Apuntes.Algoritmia;


import java.util.Arrays;

public class SortingAlgorithms {

    public static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int posLower = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j] < v[i])
                    posLower = j;

                int aux = v[i];
                v[i] = v[posLower];
                v[posLower] = aux;
        }
    }

    public static void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {
            int tmp = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > tmp) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = tmp;
        }
    }

    public static int[] mergeArrays(int[] v1, int[] v2) {
        int[] v3 = new int[v1.length + v2.length];

        int i1 = 0, i2 = 0, i3 = 0;

        while (i1 < v1.length && i2 < v2.length) {
            if (v1[i1] < v2[i2]) {
                v3[i3] = v1[i1];
                i1++;
            } else {
                v3[i3] = v2[i2];
                i2++;
            }
            i3++;
        }
        while (i1 < v1.length) {
            v3[i3] = v1[i1];
            i1++;
            i3++;
        }
        while (i2 < v2.length) {
            v3[i3] = v2[i2];
            i2++;
            i3++;
        }
        return v3;
    }

    public static void mergeSort(int[] v) {
        if (v.length <= 1) return;
        int middle = v.length / 2;
        int[] half1 = Arrays.copyOfRange(v, 0, middle);
        int[] half2 = Arrays.copyOfRange(v, middle, v.length);
        mergeSort(half1);
        mergeSort(half2);
        int[] sorted = mergeArrays(half1, half2);
        System.arraycopy(sorted, 0, v, 0, v.length);
    }
}
