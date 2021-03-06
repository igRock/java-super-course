package two_to_five;

import java.util.Arrays;

public class ExerciseTwo {
    public void execute(int arrayLength) {
        int[] array = generateEvenArray(arrayLength);
        int[] result1 = generateMultiplyArray1(array);
        int[] result2 = generateMultiplyArray2(array);
        int[] result3 = generateMultiplyArray3(array);
        int[] result4 = generateMultiplyArray4(array);

        printResultArray(result1);
        printResultArray(result2);
        printResultArray(result3);
        printResultArray(result4);
    }

    private int[] generateEvenArray(int arrayLength) {
        int[] array = new int[arrayLength];

        int j = 2;
        for (int i = 0; i < array.length; i++) {
            array[i] = j;
            j += 2;
        }
        return array;
    }

    private int[] generateMultiplyArray1(int[] array) {
        int[] result = generateResultArray(array.length);

        int i = 0;
        while (i != array.length) {
            if ((i + 1) % 2 == 0) {
                result[i / 2] = array[i] * array[i - 1];
            }
            i++;
        }
        return result;
    }

    private int[] generateMultiplyArray2(int[] array) {
        int[] result = generateResultArray(array.length);

        int i = 0;
        do {
            if ((i + 1) % 2 == 0) {
                result[i / 2] = array[i] * array[i - 1];
            }
            i++;
        } while (i != array.length);
        return result;
    }

    private int[] generateMultiplyArray3(int[] array) {
        int[] result = generateResultArray(array.length);

        for (int i = 1; i < array.length; i+=2) {
            result[i / 2] = array[i] * array[i - 1];
        }
        return result;
    }

    private int[] generateMultiplyArray4(int[] array) {
        int[] result = generateResultArray(array.length);

        int buffer = 0;
        int i = 0;
        for (int item : array) {
            if ((i + 1) % 2 == 0) {
                result[i / 2] = item * buffer;
            } else {
                buffer = item;
            }
            i++;
        }
        return result;
    }

    private void printResultArray(int[] resultArray) {
        System.out.println("Массив - " + Arrays.toString(resultArray));
    }

    private int[] generateResultArray(int inputArrayLength) {
        return new int[inputArrayLength / 2];
    }
}