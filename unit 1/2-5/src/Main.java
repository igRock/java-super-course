import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗАДАНИЕ 2:");
        ExerciseTwo exerciseTwo = new ExerciseTwo();
        exerciseTwo.execute(6);

        System.out.println("\nЗАДАНИЕ 3:");
        ExerciseThree exerciseThree = new ExerciseThree();
        exerciseThree.execute(2, 10, 1);

        System.out.println("\n\nЗАДАНИЕ 4:");
        ExerciseFour exerciseFour = new ExerciseFour();
        exerciseFour.execute(new Integer[]{-2000000,-53030303,-2020202});

        System.out.println("\nЗАДАНИЕ 5:");
        ExerciseFive exerciseFive = new ExerciseFive();
        exerciseFive.execute(9);
    }
}
