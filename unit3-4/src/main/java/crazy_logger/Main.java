package crazy_logger;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CrazyLogger logger = CrazyLogger.getLogger();
        logger.log("Message 1");
        logger.log("Message 2");
        logger.log("Message 3");
        logger.log("Message 4");
        System.out.println(logger.getLogString());
        System.out.println("Поиск по \"Message 2:\"");
        System.out.println(logger.getLogByString("Message 2"));
        System.out.println("Записи за сегодня:");
        System.out.println(logger.getLogByDate(LocalDateTime.now()));
    }
}
