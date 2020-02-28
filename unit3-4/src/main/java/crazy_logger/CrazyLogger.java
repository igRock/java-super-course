package crazy_logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {
    private static final StringBuilder loggerData = new StringBuilder(1024);
    private static CrazyLogger instance;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm");

    private CrazyLogger() {}

    public static CrazyLogger getLogger() {
        if (instance == null) {
            instance = new CrazyLogger();
        }
        return instance;
    }

    private String getLog() {
        return loggerData.toString();
    }

    private String getLog(LocalDateTime ldt) {
        return getLog(DATE_FORMAT.format(ldt));
    }

    private String getLog(String byString) {
        Pattern pattern = Pattern.compile(".*".concat(byString).concat(".*\\n"));
        Matcher matcher = pattern.matcher(loggerData.toString());
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group().trim()).append("\n");
        }
        return result.toString();
    }

    public void log(String message) {
        loggerData.append(DATE_FORMAT.format(LocalDateTime.now())).append(" - ").append(message).append("\n");
    }

    public String getLogString() {
        return getLog();
    }
    public String getLogByString(String byString) {
        return getLog(byString);
    }

    public String getLogByDate(LocalDateTime ldt) {
        return getLog(ldt);
    }
}
