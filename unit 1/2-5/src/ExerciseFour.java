public class ExerciseFour {
    public void execute(Integer[] arr) {
        printResult(getResultValue(arr));
    }

    private int getResultValue(Integer[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        // Считаем, что если элемент - ровно по середине - то, он умножается на 2
        int middleIndex = arr.length / 2 + 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < middleIndex; i++) {
            int sum = arr[i] + arr[arr.length - i - 1];
            // В процессе обхода массива - мы обновляем максимальное значение, если такое имеется
            result = result < sum ? sum : result;
        }
        return result;
    }

    private void printResult(int result) {
        System.out.println("Максимальная сумма - " + result);
    }
}

