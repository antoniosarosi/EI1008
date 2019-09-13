package tests.Apuntes.EstructuraDatos;

import Apuntes.EstructuraDatos.Matriz.ArraysMatrix;
import Apuntes.EstructuraDatos.Matriz.DynamicArrayMatrix;
import Apuntes.EstructuraDatos.Matriz.DynamicMatrix;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DynamicArrayMatrixTest {

    private DynamicMatrix matrix;
    private int[][] m;

    private DynamicMatrix createEmptyMatrix() {
//        return new DynamicArrayMatrix();
        return new ArraysMatrix();
    }

    private DynamicMatrix createMatrix(int[][] m) {
        return new ArraysMatrix(m);
    }

    @Before
    public void setUp() {
        m = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        matrix = createMatrix(m);
    }

    private void checkSize(int expectedRows, int expectedCols) {
        assertEquals("El tamaño de las filas no es el esperado", expectedRows, matrix.numOfRows());
        assertEquals("El tamaño de las columnas no es el esperado", expectedCols, matrix.numOfCols());
    }

    private void checkStringForm(int[][] expectedMatrix) {
        assertEquals("Incorrect String Form", buildExpectedString(expectedMatrix), matrix.toString());
    }

    private String buildExpectedString(int[][] matrix) {
        StringBuilder str = new StringBuilder("String form {");
        for (int[] i : matrix)
            str.append("\n\t").append(Arrays.toString(i));
        str.append("\n}");

        return str.toString();
    }

    @Test
    public void constructorTests() {
        checkSize(m.length, m[0].length);
        checkStringForm(m);
        matrix = createEmptyMatrix();
        checkSize(0, 0);
    }

    @Test
    public void getTest() {
        assertEquals("get() está fallando", m[0][0], matrix.get(0, 0));
        assertEquals("get() está fallando", m[1][3], matrix.get(1, 3));
        assertEquals("get() está fallando", m[2][2], matrix.get(2, 2));
    }

    @Test
    public void setTest() {
        m[0][0] = 12;
        matrix.set(0, 0, 12);
        assertEquals("set() falla", m[0][0], matrix.get(0, 0));
        checkStringForm(m);

        m[1][2] = 12;
        matrix.set(1, 2, 12);
        assertEquals("set() falla", m[1][2], matrix.get(1, 2));
        checkStringForm(m);

        m[2][3] = 12;
        matrix.set(2, 3, 12);
        assertEquals("set() falla", m[2][3], matrix.get(2, 3));
        checkStringForm(m);
    }

    @Test
    public void getRowTest() {
        int i = 0;
        for (int[] row : m)
            assertArrayEquals("Rows are not equal", row, matrix.getRow(i++));
    }

    @Test
    public void getColTest() {
        int[] expectedCol = new int[m.length];
        for (int j = 0; j < m[0].length; j++) {
            for (int i = 0; i < m.length; i++)
                expectedCol[i] = m[i][j];
            assertArrayEquals("Columns are not equal", expectedCol, matrix.getCol(j));
        }
    }

    @Test
    public void addRowTest() {
        int[] rowToAdd = new int[m[0].length];
        Arrays.fill(rowToAdd, 100);
        int[][] expected = new int[m.length + 1][m[0].length];
        System.arraycopy(m, 0, expected, 0, m.length);
        expected[expected.length - 1] = rowToAdd;
        matrix.addRow(rowToAdd);
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    @Test
    public void addColTest() {
        int[] col = new int[m.length];
        Arrays.fill(col, 200);
        for (int i = 0; i < m.length; i++) {
            int[] newRow = new int[m[i].length + 1];
            System.arraycopy(m[i], 0, newRow, 0, m[i].length);
            newRow[m[i].length] = col[0];
            m[i] = newRow;
        }
        matrix.addCol(col);
        checkSize(m.length, m[0].length);
        checkStringForm(m);
    }

    @Test
    public void insertRowTest() {
        ArrayList<int[]> expected = new ArrayList<>(Arrays.asList(m));
        int[] newRow = new int[m.length];
        for (int i = 0; i < m.length; i++)
            newRow[i] = 300;
        expected.add(1, newRow);
        matrix.insertRow(1, newRow);
        checkStringForm(expected.toArray(new int[expected.size()][]));
        checkStringForm(expected.toArray(new int[expected.size()][]));
    }

    @Test
    public void insertColTest() {
        int[] col = new int[m.length];
        Arrays.fill(col, 400);

        ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
        for (int[] i : m) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j : i)
                row.add(j);
            aux.add(row);
        }
        for (ArrayList<Integer> r : aux)
            r.add(2, col[0]);

        int[][] expected = new int[aux.size()][aux.get(0).size()];
        for (int i = 0; i < expected.length; i++)
            for (int j = 0; j < expected[0].length; j++)
                expected[i][j] = aux.get(i).get(j);

        matrix.insertCol(2, col);
        checkSize(expected.length, expected[0].length);
        checkStringForm(expected);
    }

    @Test
    public void removeRowTest() {
        int[][] expected = new int[m.length - 1][m[0].length];
        System.arraycopy(m, 1, expected, 0, m.length - 1);
        assertArrayEquals(m[0], matrix.removeRow(0));
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    @Test
    public void removeColTest() {
        int[][] expected = new int[m.length][m[0].length - 1];
        for (int i = 0; i < m.length; i++)
            if (m[0].length - 1 >= 0) System.arraycopy(m[i], 1, expected[i], 0, m[0].length - 1);
        matrix.removeCol(0);
        checkSize(expected.length, expected[0].length);
        checkStringForm(expected);
    }

    @Test
    public void rotateRightTest() {
        int[][] expected = rotateRight(m);
        matrix.rotateRight();
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    private int[][] rotateRight(int[][] original) {
        int[][] rotated = new int[original[0].length][original.length];
        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < original[0].length; j++)
                rotated[j][original.length - i - 1] = original[i][j];
        return rotated;
    }

    @Test
    public void rotateLeftTest() {
        int[][] expected = rotateLeft(m);
        matrix.rotateLeft();
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    private int[][] rotateLeft(int[][] original) {
        int[][] rotated = new int[original[0].length][original.length];
        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < original[0].length; j++)
                rotated[original[0].length - 1 - j][i] = original[i][j];
        return rotated;
    }

    @Test
    public void reflectHorizontalTest() {
        int[][] expected = reflectHorizontal(m);
        matrix.reflectHorizontal();
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    private int[][] reflectHorizontal(int[][] original) {
        int[][] reflected = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++)
            System.arraycopy(original[i], 0, reflected[original.length - 1 - i], 0, original[0].length);
        return reflected;
    }

    @Test
    public void reflectVerticalTest() {
        int[][] expected = reflectVertical(m);
        matrix.reflectVertical();
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    private int[][] reflectVertical(int[][] original) {
        int[][] reflected = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < original[0].length; j++)
                reflected[i][original[0].length -1 - j] = original[i][j];
        return reflected;
    }

    @Test
    public void transposeTest() {
        int[][] expected = transpose(m);
        matrix.transpose();
        assertEquals(buildExpectedString(expected), matrix.toString());
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }

    private int[][] transpose(int[][] original) {
        int[][] transposed = new int[original[0].length][original.length];
        for (int i = 0; i < original.length; i++)
            for (int j = 0; j < original[0].length; j++)
                transposed[j][i] = original[i][j];
        return transposed;
    }

    @Test
    public void clearTest() {
        matrix.clear();
        checkStringForm(new int[][] {});
        checkSize(0, 0);
    }

    @Test
    public void rotationsTest() {
        for (int i = 0; i < 2; i++) {
            m = rotateRight(m);
            matrix.rotateRight();
            checkAtributes(m);
        }
        m = transpose(m);
        matrix.transpose();
        checkAtributes(m);

        m = rotateLeft(m);
        matrix.rotateLeft();
        checkAtributes(m);

        m = reflectHorizontal(m);
        matrix.reflectHorizontal();
        checkAtributes(m);

        m = reflectVertical(m);
        matrix.reflectVertical();
        checkAtributes(m);
    }

    private void checkAtributes(int[][] expected) {
        checkStringForm(expected);
        checkSize(expected.length, expected[0].length);
    }
}