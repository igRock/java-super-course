package locale;

import java.util.*;

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

        List<String> questions = getQuestions(bundle);
        System.out.println("Выберите номер вопроса. Всего вопросов - " + questions.size());

        for(String question: questions) {
            System.out.println(question);
        }

        String questionNumber = scanner.nextLine();
        System.out.println(getAnswerById(Integer.parseInt(questionNumber), bundle));
    }

    private static String getAnswerById(Integer index, ResourceBundle bundle) {
        return bundle.getString("answer" + index);
    }

    private static List<String> getQuestions(ResourceBundle bundle) {
        List<String> questions = new LinkedList<>();
        for (int i = 1; i <= bundle.keySet().size() / 2; i++) {
            questions.add(bundle.getString("question" + i));
        }
        return questions;
    }
}
