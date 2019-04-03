package academy.elqoo.java8.dateandtime;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTime8 {

    public static final long DAYS_BETWEEN = 5;

    public static LocalDate createNewYearsEve2018(){
        return LocalDate.of(2018,12,31);
    }

    public static LocalDate[] getTwoLocalDates(){
        LocalDate[] dates = new LocalDate[2];
        dates[0] = LocalDate.now();
        dates[1] = dates[0].plusDays(DAYS_BETWEEN);
        return dates;
    }

    public static LocalDate findNextFriday13th(LocalDate from){
        LocalDate fridayTheThirteen = from;
        while(fridayTheThirteen.getDayOfMonth() != 13){
            fridayTheThirteen = fridayTheThirteen.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return fridayTheThirteen;
        //nie rozumiem tej metody jej dziłania.
    }

}
