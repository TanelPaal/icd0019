package types;

public class Pmd {

    public static void main(String[] args) {
        boolean[][] matrix = getSampleMatrix();

        printMatrix(matrix);

        System.out.println(containsTrueCell(matrix));
        System.out.println(findFirstTrueCell(matrix));
        System.out.println(countTrueRow(matrix));
    }

    private static void printMatrix(boolean[][] sampleMatrix) {
        for (boolean[] row : sampleMatrix) {
            for (boolean element : row) {
                System.out.print(element ? "X" : "O");
            }
            System.out.println();
        }
    }

    // intentionally bad code
    public static boolean containsTrueCell(boolean[][] matrix) {
        boolean result = false;
        if (matrix[0][0]) {
            result = true;
        } else if (matrix[0][1]) {
            result = true;
        } else if (matrix[0][2]) {
            result = true;
        } else if (matrix[1][0]) {
            result = true;
        } else if (matrix[1][1]) {
            result = true;
        } else if (matrix[1][2]) {
            result = true;
        } else if (matrix[2][0]) {
            result = true;
        } else if (matrix[2][1]) {
            result = true;
        } else if (matrix[2][2]) {
            result = true;
        }

        return result;
    }

    // intentionally bad code
    public static int findFirstTrueCell(boolean[][] matrix) {
        if (matrix[0][0]) {
            return 1;
        } else if (matrix[0][1]) {
            return 2;
        } else if (matrix[0][2]) {
            return 3;
        } else if (matrix[1][0]) {
            return 4;
        } else if (matrix[1][1]) {
            return 5;
        } else if (matrix[1][2]) {
            return 6;
        } else if (matrix[2][0]) {
            return 7;
        } else if (matrix[2][1]) {
            return 8;
        } else if (matrix[2][2]) {
            return 9;
        }

        return -1;
    }

    // intentionally bad code
    public static int countTrueRow(boolean[][] matrix) {
        for (boolean[] booleans : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (booleans[j]) {
                    int count = 0;
                    for (int k = 0; k < matrix.length; k++) {
                        if (booleans[k]) {
                            count++;
                        }
                    }

                    return count;
                }
            }
        }
        return -1;
    }

    private static boolean[][] getSampleMatrix() {
        boolean[][] matrix = new boolean[3][3];

        matrix[2][1] = true;
        matrix[2][2] = true;

        return matrix;
    }

}
