package processor;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       NumMatrix firstMatrix = initializeMatrix();
       NumMatrix secondMatrix = initializeMatrix();
       NumMatrix sumMatrix = firstMatrix.addMatrix(secondMatrix);

       if (sumMatrix != null) {
           sumMatrix.print();
       }
    }

    public static NumMatrix initializeMatrix() {
        int rows, columns;
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        NumMatrix matrix = new NumMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.addValue(scanner.nextInt(), i, j);
            }
        }
        return matrix;
    }
}
