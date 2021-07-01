package dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodsMain {
    public static void main(String[] args) {
        boolean is = (LocalDate.of(2021, Month.MAY, 1)).isBefore(
                LocalDate.of(2021, Month.MAY, 1)
        );
        System.out.println(is);//одинаковые даты - false



        abc(
                LocalDate.of(2021, Month.MAY, 1),
                LocalDate.of(2025, Month.JULY, 31),
                Period.of(1, 3, 15)
        );


        //сработает последний!!!
//        Period p = Period.ofYears(1).ofMonths(2);
        //т.к. равносильная запись
        Period p = Period.ofYears(1);//работает только с датами
        p = Period.ofMonths(2);
        System.out.println(p.toTotalMonths());

        Duration d = Duration.ofDays(3);//работает только со временем
        System.out.println(d.toDays());
    }



    static void abc(LocalDate start, LocalDate end, Period p) {
        for (; start.isBefore(end); start.plus(p)) {
            System.out.println(start);

            //при добавлении периода к LocalTime будет RUNTIME exception!!!
            //Period - работает только с датами (LocalDate)
            //Duration  - работает только со временем (LocalTime, LocalDateTime)
            start = start.plus(p);
        }
    }
}
