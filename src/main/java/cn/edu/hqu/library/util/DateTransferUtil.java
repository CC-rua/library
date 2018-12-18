package cn.edu.hqu.library.util;

import java.time.*;
import java.util.Date;

public class DateTransferUtil {

    public static LocalDate DateToLocalDate(Date date)
    {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    public static Date LocalDateToDate(LocalDate localDate)
    {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
        return date;
    }

}
