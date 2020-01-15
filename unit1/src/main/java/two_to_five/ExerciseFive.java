package two_to_five;

import java.util.Arrays;

public class ExerciseFive {
    public void execute(int size) {
        printMatrix(getMatrix(size));
    }

    private int[][] getMatrix(int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                //Либо 1, либо 0
                result[i][j] = j == i ? 1 : 0;
                // По умолчанию - 0
                result[i][size - i - 1] = 1;
            }
        }
        return result;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}