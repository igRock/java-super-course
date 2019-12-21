import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        exercise2(5);

        exercise3(2, 10, 1);

        exercise4(new Integer[]{2,6,6});

        exercise5(9);
    }

    // ЗАДАНИЕ 2
    private static void exercise2(int arrayLength) {
        System.out.println("\nЗАДАНИЕ 2:");
        Integer[] array = new Integer[arrayLength];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            while (array[array.length - 1] == null) {
                if (++j % 2 == 0) {
                    array[i] = j;

                    // Каждый второй элемент массива умножаем на предыдущий
                    if ((i + 1) % 2 == 0) {
                        System.out.println(String.format("Произведение %s элемента на предыдущий равно - %s", i + 1,
                                array[i] * array[i - 1]));
                    }
                    break;
                }
            }
        }
        System.out.println("Массив - " + Arrays.toString(array));
    }

    //ЗАДАНИЕ 3
    private static void exercise3(int start, int end, int step) {
        System.out.println("\nЗАДАНИЕ 3:");
        System.out.printf("%-25s", "Задание параметра X:");
        System.out.printf("%-20s", "F(x) = tg(2x) - 3");
        for (int x = start; x <= end; x += step) {
            System.out.println();
            System.out.printf("%-25s", x);
            System.out.printf("%-20s", Math.tan(2 * x) - 3);
        }
        System.out.println();
    }

    // ЗАДАНИЕ 4
    private static void exercise4(Integer[] arr) {
        System.out.println("\nЗАДАНИЕ 4:");
        // Считаем, что если элемент - ровно по середине - то, он умножается на 2
        int middleIndex = arr.length / 2 + 1;

        int result = 0;
        for (int i = 0; i < middleIndex; i++) {
            int sum = arr[i] + arr[arr.length - i - 1];

            // В процессе обхода массива - мы обновляем максимальное значение, если такое имеется
            result = result < sum ? sum : result;
        }
        System.out.println("Максимальная сумма - " + result);
    }

    // ЗАДАНИЕ 5
    private static void exercise5(int size) {
        System.out.println("\nЗАДАНИЕ 5:");
        int[][] field = new int[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                //Либо 1, либо 0
                field[i][j] = j == i ? 1 : 0;

                // По умолчанию - 0
                field[i][size - i - 1] = 1;
            }
            System.out.println(Arrays.toString(field[i]));
        }
    }
}
