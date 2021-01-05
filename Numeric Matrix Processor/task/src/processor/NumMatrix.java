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

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
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

    public NumMatrix diagonalTranspose() {
        NumMatrix transposeMatrix = new NumMatrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix.addValue(this.getValue(i, j), j, i);
            }
        }
        return transposeMatrix;
    }

    public NumMatrix sideTranspose() {
        NumMatrix transposeMatrix = new NumMatrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix.addValue(this.getValue(i, j), rows - (j + 1), columns - (i + 1));
            }
        }
        return transposeMatrix;
    }

    public NumMatrix verticalTranspose() {
        NumMatrix transposeMatrix = new NumMatrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix.addValue(this.getValue(i, j), i, columns - (j + 1));
            }
        }
        return transposeMatrix;
    }

    public NumMatrix horizontalTranspose() {
        NumMatrix transposeMatrix = new NumMatrix(columns, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix.addValue(this.getValue(i, j), columns - (i + 1), j);
            }
        }
        return transposeMatrix;
    }

    private void getCofactor(NumMatrix temp, int p, int q) {
        int i = 0, j = 0;

        for (int row = 0; row < this.getRows(); row++)
        {
            for (int col = 0; col < this.getColumns(); col++)
            {
                if (row != p && col != q)
                {
                    temp.addValue(this.getValue(row, col), i, j++);

                    if (j == this.getRows() - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    public double matrixDeterminant() {

        double determinant = 0;

        if (this.rows == 1) {
            return this.getValue(0, 0);
        }

        NumMatrix temp = new NumMatrix(this.getRows(), this.getColumns());

        int sign = 1;

        for (int f = 0; f < this.getRows(); f++)
        {
            // Getting Cofactor of mat[0][f]
            getCofactor(temp, 0, f);
            temp.setRows(this.getRows() - 1);
            temp.setColumns(this.getColumns() - 1);
            determinant += sign * this.getValue(0, f)
                    * temp.matrixDeterminant();

            sign = -sign;
        }

        return determinant;
    }

}


