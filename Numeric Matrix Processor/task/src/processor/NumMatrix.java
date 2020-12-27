package processor;

import java.util.Arrays;

public class NumMatrix {
    private int rows;
    private int columns;
    private int[][] matrix;

    public NumMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new int[this.rows][this.columns];
    }

    public void addValue(int value, int row, int column) {
        matrix[row][column] = value;
    }

    public int getValue(int row, int column) {
        return matrix[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public NumMatrix addMatrix(NumMatrix matrix2) {
        if (rows != matrix2.getRows() || columns != matrix2.getColumns()) {
            System.out.println("ERROR");
            return null;
        }
        NumMatrix sumMatrix = new NumMatrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sumMatrix.addValue(matrix[i][j] + matrix2.getValue(i, j), i, j);
            }
        }

        return sumMatrix;
    }


    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(getValue(i,j) + " ");
            }
            System.out.print("\n");
        }
    }
}
