package two_to_five;

public class ExerciseThree {

    private static final String COLUMN_WIDTH_1 = "%-25s";
    private static final String COLUMN_WIDTH_2 = "%-20s";

    public void execute(int start, int end, int step) {
        printTableLine("Задание параметра X:", "F(x) = tg(2x) - 3");
        for (int x = start; x <= end; x += step) {
            printTableLine(Integer.toString(x), Double.toString(getFunctionValue(x)));
        }
    }

    private void printTableLine(String value1, String value2) {
        System.out.println();
        System.out.printf(COLUMN_WIDTH_1, value1);
        System.out.printf(COLUMN_WIDTH_2, value2);
    }

    private double getFunctionValue(int x) {
        return Math.tan(2 * x) - 3;
    }
}