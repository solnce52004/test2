package dates.formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatterMain {
    final static DateTimeFormatter formatLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
    final static DateTimeFormatter formatLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    final static DateTimeFormatter formatDateTime = DateTimeFormatter.ISO_DATE_TIME;
    final static DateTimeFormatter formatTime = DateTimeFormatter.ISO_TIME;

    final static DateTimeFormatter formatLocalizedShort = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
    final static DateTimeFormatter formatLocalizedLongTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);

    final static DateTimeFormatter formatLocalizedLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
    final static DateTimeFormatter formatLocalizedFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);


    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2021, 5, 31);
        System.out.println(date.format(formatLocalDate));//2021-05-31



        LocalDateTime dateTime = LocalDateTime.of(
                2021,
                5,
                31,
                12,
                45
        );
        System.out.println(dateTime.format(formatLocalDate));//2021-05-31
        System.out.println(dateTime.format(formatLocalDateTime));//2021-05-31T12:45:00
        System.out.println(dateTime.format(formatDateTime));//2021-05-31T12:45:00
        System.out.println(dateTime.format(formatTime));//12:45:00


        System.out.println(dateTime.format(formatLocalizedShort));//12:45 - long-error!
//        System.out.println(dateTime.format(formatLocalizedLongTime));//error!

        System.out.println(dateTime.format(formatLocalizedLong));//time-error! date-ok //п31 мая 2021 г.
        System.out.println(dateTime.format(formatLocalizedFull));//time-error! date-ok //понедельник, 31 мая 2021 г.

        //МОЖНО ВЫЗЫВАТЬ НАОБОРОТ!!!! от формата!
        System.out.println(formatLocalizedFull.format(dateTime));

        //СВОИ ФОРМАТЫ! (y - low case)
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("y-MM-dd hh:mm:ss");//2021-05-31 12:45:00
        System.out.println(dateTime.format(customFormat));

        DateTimeFormatter customFormat2 = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss");//21-05-31 12:45:00
        System.out.println(dateTime.format(customFormat2));


        //создание объекта в стандартном формате
        DateTimeFormatter sf = DateTimeFormatter.ofPattern("y   MM dd");//пробелы должны совпадать с той строкой кот парсим!
        LocalDate lDate = LocalDate.parse("2021   03 15", sf);//2021-03-15 - стандартный вывод!
        System.out.println(lDate);
        System.out.println(lDate.format(DateTimeFormatter.ofPattern("y-MM")));
    }
}
