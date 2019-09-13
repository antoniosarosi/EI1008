package Apuntes.EstructuraDatos.Matriz;

import java.util.ArrayList;

public class ArraysMatrix implements DynamicMatrix {

    private ArrayList<ArrayList<Integer>> matrix;

    public ArraysMatrix() {
        matrix = new ArrayList<>();
    }

    public ArraysMatrix(int[][] m) {
        this();
        for (int[] i : m) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j : i)
                row.add(j);
            matrix.add(row);
        }
    }

    public int get(int i, int j) {
        return matrix.get(i).get(j);
    }

    public int set(int i, int j, int data) {
        int prev = get(i, j);
        matrix.get(i).set(j, data);
        return prev;
    }

    public int numOfRows() {
        return matrix.size();
    }

    public int numOfCols() {
        if (matrix.size() == 0)
            return 0;
        return matrix.get(0).size();
    }

    public int[] getRow(int i) {
        int[] row = new int[numOfCols()];
        int r = 0;
        for (int e : matrix.get(i))
            row[r++] = e;
        return row;
    }

    public int[] getCol(int j) {
        int[] col = new int[numOfRows()];
        int c = 0;
        for (ArrayList<Integer> row : matrix)
            col[c++] = row.get(j);
        return col;
    }

    public void addRow(int[] row) {
        ArrayList<Integer> newRow = new ArrayList<>();
        for (int i : row)
            newRow.add(i);
        matrix.add(newRow);
    }

    public void addCol(int[] col) {
        if (matrix.size() == 0)
            for (int e : col) {
                ArrayList<Integer> row = new ArrayList<>();
                row.add(e);
                matrix.add(row);
            }
        else {
            int j = 0;
            for (ArrayList<Integer> i : matrix)
                i.add(col[j++]);
        }
    }

    public void insertRow(int i, int[] row) {
        ArrayList<Integer> newRow = new ArrayList<>();
        for (int r : row)
            newRow.add(r);
        matrix.add(i, newRow);
    }

    public void insertCol(int j, int[] col) {
        int c = 0;
        for (ArrayList<Integer> i : matrix)
            i.add(j, col[c++]);
    }

    public int[] removeRow(int i) {
        int[] removedRow = new int[numOfCols()];
        int r = 0;
        for (int e : matrix.get(i))
            removedRow[r++] = e;
        matrix.remove(i);
        return removedRow;
    }

    public int[] removeCol(int j) {
        int[] removedCol = new int[numOfRows()];
        int c = 0;
        for (ArrayList<Integer> r : matrix)
            removedCol[c++] = r.remove(j);
        return removedCol;
    }

    public void rotateRight() {
        ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
        for (int j = 0; j < numOfCols(); j++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = numOfRows() - 1; i >= 0; i--)
                row.add(get(i, j));
            aux.add(row);
        }
        matrix = aux;
    }

    public void rotateLeft() {
        ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
        for (int j = numOfCols() - 1; j >= 0; j--) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < numOfRows(); i++)
                row.add(get(i, j));
            aux.add(row);
        }
        matrix = aux;
    }

    public void reflectHorizontal() {
        for (int i = 0, j = numOfRows() - 1; i < numOfRows() / 2; i++, j--) {
            ArrayList<Integer> aux = matrix.get(i);
            matrix.set(i, matrix.get(j));
            matrix.set(j, aux);
        }
    }

    public void reflectVertical() {
         ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
         for (int i = 0; i < numOfRows(); i++) {
             ArrayList<Integer> row = new ArrayList<>();
             for (int j = numOfCols() - 1; j >= 0; j--)
                 row.add(get(i, j));
             aux.add(row);
         }
         matrix = aux;
    }

    public void transpose() {
        ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
        for (int j = 0; j < numOfCols(); j++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < numOfRows(); i++)
                row.add(get(i, j));
            aux.add(row);
        }
        matrix = aux;
    }

    public void clear() {
        matrix = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("String form {");
        for (ArrayList<Integer> row : matrix)
            str.append("\n\t").append(row);
        str.append("\n}");

        return str.toString();
    }
}
