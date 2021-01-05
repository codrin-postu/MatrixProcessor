package processor;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        outputMenu();
        int option = getMenuChoice();

        NumMatrix matrix1;
        NumMatrix matrix2;
        double constant;

        switch (option) {
            case 0:
                System.exit(0);
            case 1:
                matrix1 = readMatrix();
                matrix2 = readMatrix();
                NumMatrix sumMatrix = matrix1.addMatrix(matrix2);
                System.out.println("The result is:");
                sumMatrix.print();
                break;
            case 2:
                matrix1 = readMatrix();
                constant = readConstant();
                matrix1.multiplyMatrix(constant);
                System.out.println("The result is:");
                matrix1.print();
                break;
            case 3:
                matrix1 = readMatrix();
                matrix2 = readMatrix();
                NumMatrix mulMatrix = matrix1.multiplyMatrix(matrix2);
                System.out.println("The result is:");
                mulMatrix.print();
                break;
            case 4:
                int transposeOption = transposeOption();
                matrix1 = readMatrix();
                NumMatrix transposedMatrix = transposeMatrix(matrix1, transposeOption);
                System.out.println("The result is:");
                transposedMatrix.print();
                break;
            case 5:
                matrix1 = readMatrix();
                if (matrix1.getColumns() != matrix1.getRows()) {
                    System.out.println("ERROR! Invalid matrix.");
                    break;
                }
                System.out.println("The result is:");
                System.out.println(matrix1.matrixDeterminant());
                break;
        }
        mainMenu();
    }

    //TODO: Change to enum
    private static int transposeOption() {
        System.out.print(
                "1. Main diagonal\n" +
                        "2. Side diagonal\n" +
                        "3. Vertical line\n" +
                        "4. Horizontal line\n" +
                        "0. Exit\n" +
                        "Your choice: "
        );
        return scanner.nextInt();
    }

    private static double readConstant() {
        System.out.print("Enter constant: ");
        return scanner.nextDouble();
    }

    private static int getMenuChoice() {
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    private static void outputMenu() {
        System.out.println(
                "1. Add matrices\n" +
                        "2. Multiply matrix by a constant\n" +
                        "3. Multiply matrices\n" +
                        "4. Transpose matrix\n" +
                        "5. Calculate a determinant\n" +
                        "0. Exit"
        );
    }

    public static NumMatrix readMatrix() {
        System.out.print("Enter size of matrix: ");
        int rows, columns;
        rows = scanner.nextInt();
        columns = scanner.nextInt();

        NumMatrix matrix = new NumMatrix(rows, columns);

        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.addValue(scanner.nextDouble(), i, j);
            }
        }
        return matrix;
    }

    public static NumMatrix transposeMatrix(NumMatrix matrix, int transposeOption) {
        switch (transposeOption) {
            case 1:
                return matrix.diagonalTranspose();
            case 2:
                return matrix.sideTranspose();
            case 3:
                return matrix.verticalTranspose();
            case 4:
                return matrix.horizontalTranspose();
            default:
                System.out.println("ERROR: Incorrect transpose choice!");
                return null;
        }
    }
}
