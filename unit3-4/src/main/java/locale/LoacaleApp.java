package locale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LoacaleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите язык. 1 - Русский, 2 - English");
        String lang = scanner.nextLine();

        ResourceBundle bundle;
        if ("1".equals(lang)) {
            bundle = ResourceBundle.getBundle("questions", new Locale("ru", "RU"));
        } else if ("2".equals(lang)) {
            bundle = ResourceBundle.getBundle("questions", Locale.ENGLISH);
        } else {
            throw new RuntimeException("Введено неправильное значение");
        }

        showQuestionsAndAnswers(bundle);
    }

    private static void showQuestionsAndAnswers(ResourceBundle bundle) {
        for(String key : bundle.keySet()) {
            System.out.println(bundle.getString(key));
        }
    }
}
