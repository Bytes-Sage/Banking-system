package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private static final DateTimeFormatter STANDARD_FORMAT=  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter SHORT_DATE_FORMAT=DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private static final DateTimeFormatter LONG_FORMAT = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss");

    public static String formatStandard(LocalDateTime dateTime){
        if(dateTime==null){
            return "N/A";
        }
        return dateTime.format(STANDARD_FORMAT);

    }

    public static String formatShortDate(LocalDateTime dateTime){
        if(dateTime ==null){
            return "N/A";
        }
        return dateTime.format(SHORT_DATE_FORMAT);
    }

    public static String formatLong(LocalDateTime dateTime){
        if(dateTime ==null){
            return "N/A";
        }
        return dateTime.format(LONG_FORMAT);
    }

    public static String getCurrentDateTime(){
        return formatStandard(LocalDateTime.now());
    }
}
