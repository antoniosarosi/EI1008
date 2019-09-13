package Apuntes.EstructuraDatos.Matriz;

public interface DynamicMatrix {

    int get(int i, int j);

    int set(int i, int j, int data);

    int numOfRows();

    int numOfCols();

    int[] getRow(int i);

    int[] getCol(int j);

    void addRow(int[] row);

    void addCol(int[] col);

    void insertRow(int i, int[] row);

    void insertCol(int j, int[] col);

    int[] removeRow(int i);

    int[] removeCol(int j);

    void rotateRight();

    void rotateLeft();

    void reflectHorizontal();

    void reflectVertical();

    void transpose();

    void clear();
}
