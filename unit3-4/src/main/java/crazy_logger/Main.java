package crazy_logger;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CrazyLogger logger = CrazyLogger.getLogger();
        logger.log("Message 1");
        logger.log("Message 2");
        logger.log("Message 3");
        logger.log("Message 4");
        logger.printLog();
        System.out.println("Поиск по \"Message 2:\"");
        logger.printLog("Message 2");
        System.out.println("Записи за сегодня:");

        logger.printLog(LocalDateTime.now());
    }
}
