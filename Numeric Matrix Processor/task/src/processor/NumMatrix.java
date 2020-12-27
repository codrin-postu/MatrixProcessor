package processor;

import java.util.Arrays;

public class NumMatrix {
    private int rows;
    private int columns;
    private double[][] matrix;

    public NumMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[this.rows][this.columns];
    }

    public void addValue(double value, int row, int column) {
        matrix[row][column] = value;
    }

    public double getValue(int row, int column) {
        return matrix[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void multiplyMatrix(double constant) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                addValue(matrix[i][j] * constant, i, j);
            }
        }
    }

    public NumMatrix multiplyMatrix(NumMatrix matrix2) {
        if (columns != matrix2.getRows()) {
            System.out.println("ERROR");
            return null;
        }
        NumMatrix mulMatrix = new NumMatrix(this.rows, matrix2.getColumns());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                double dotProduct = 0;
                for (int k = 0; k < columns; k++) {
                    dotProduct = dotProduct + this.getValue(i, k) * matrix2.getValue(k, j);
                }
                mulMatrix.addValue(dotProduct, i, j);
            }
        }

        return mulMatrix;
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
                System.out.print(getValue(i, j) + " ");
            }
            System.out.print("\n");
        }
    }
}
