package academy.elqoo.java8.dateandtime;

import org.junit.Test;
import sun.text.resources.FormatData;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static java.time.Month.*;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DateAndTimeTest {

    @Test
    public void shouldCreateNewDate(){
        LocalDate newYearsEve = LocalDate.of(2018,12,31); // create new years eve 2017 using the localdate static factory methods
        assertThat(newYearsEve.getYear(), is(equalTo(2018)));
        assertThat(newYearsEve.getMonth(), is(equalTo(Month.DECEMBER)));
        assertThat(newYearsEve.getDayOfMonth(), is(equalTo(31)));
        //DONE
    }

    @Test
    public void shouldGotoFirstOfNextMonth(){
        LocalDate newYearsEve = DateTime8.createNewYearsEve2018();
        LocalDate firstJanuary2018 = newYearsEve.plusDays(1);
        assertThat(firstJanuary2018.getYear(), is(equalTo(2019)));
        assertThat(firstJanuary2018.getMonth(), is(equalTo(SEPTEMBER)));
        assertThat(firstJanuary2018.getDayOfMonth(), is(equalTo(01)));
        //DONE
    }

    @Test
    public void shouldRetrieveDateInformationUsingChronoFields(){
        LocalDate newYearsEve = DateTime8.createNewYearsEve2018();
        int year = newYearsEve.get(ChronoField.YEAR); // replace this by getting the year using chrono fields interface
        int month =newYearsEve.get(ChronoField.MONTH_OF_YEAR);
        int day = newYearsEve.getDayOfMonth();
        assertThat(year, is(equalTo(newYearsEve.getYear())));
        assertThat(month, is(equalTo(12)));
        assertThat(day, is(equalTo(newYearsEve.getDayOfMonth())));
        //DONE
    }

    @Test
    public void shouldParseLocalDate(){
        String newYearsEveAsString = "2018-12-31";
        LocalDate newYearsEve = LocalDate.parse(newYearsEveAsString); // parse the string to a date
        assertThat(newYearsEve.getYear(), is(equalTo(2018)));
        assertThat(newYearsEve.getMonth(), is(equalTo(DECEMBER)));
        assertThat(newYearsEve.getDayOfMonth(), is(equalTo(31)));
        //DONE
    }

    @Test(expected = DateTimeParseException.class)
    public void shouldThrowParseException(){
        String newYearsEveAsString = "";
        LocalDate newYearsEve = LocalDate.parse(newYearsEveAsString); // parse the an error
        //DONE
    }

    @Test
    public void shouldParseLocalTime(){
        String midnightAsString = "00:00:00";
        LocalTime midnight = LocalTime.parse(midnightAsString); // parse the time
        assertThat(midnight.getHour(), is(equalTo(0)));
        assertThat(midnight.getMinute(), is(equalTo(0)));
        assertThat(midnight.getSecond(), is(equalTo(0)));
        //DONE
    }

    @Test
    public void shouldCreateLocalDateTimeNewYearsEve(){
        LocalDateTime newYearsEve = LocalDateTime.of(2018,12,31, 0,0,0); // create LocalDateTime for new years eve at midnight
        assertThat(newYearsEve.getYear(), is(equalTo(2018)));
        assertThat(newYearsEve.getMonth(), is(equalTo(Month.DECEMBER)));
        assertThat(newYearsEve.getDayOfMonth(), is(equalTo(31)));
        assertThat(newYearsEve.getHour(), is(equalTo(0)));
        assertThat(newYearsEve.getMinute(), is(equalTo(0)));
        assertThat(newYearsEve.getSecond(), is(equalTo(0)));
    }

    @Test
    public void shouldCreateNewYearsInstant(){
        Instant newYearsEveInstant = Instant.ofEpochMilli(1554302261); // use https://www.epochconverter.com/ to create the instance
        assertNotNull(newYearsEveInstant);
        //DONE
    }

    @Test
    public void shouldCalculateDaysBetween(){
        LocalDate[] dates = DateTime8.getTwoLocalDates();
        long daysBetween = Period.between(dates[0],dates[1]).getDays();// calculate days between dates[0] and dates[1]
        //tego trezba się nauczyć nie do domyslenia
        assertThat(DateTime8.DAYS_BETWEEN, equalTo(daysBetween));
    }

    @Test
    public void shouldCreateDurationFromTemporalUnit(){
        Duration duration = Duration.ofSeconds(5); // create a duration of 5 seconds
        long seconds = duration.getSeconds();
        assertThat(5L, equalTo(seconds));
        //DONE
    }

    @Test
    public void shouldCheckIfDurationIsZero(){
        Duration duration = Duration.ofDays(5); // create a duration of 5 days
        boolean isZero = duration.isZero(); // check for the duration if it's zero
        assertThat(false, equalTo(isZero));
        //DONE
    }

    @Test
    public void shouldFormatToString(){
        LocalDate newYearsEve = DateTime8.createNewYearsEve2018();
        System.out.println(newYearsEve);
        String format = newYearsEve.format(ISO_DATE); // format the string
        assertThat("2018-12-31",equalTo(format));
        //do nauczenia nie do domyślenia
        //DONE
    }

    @Test
    public void shouldUseWithMethodtoChangeDate() {
        LocalDate newYearsEve = DateTime8.createNewYearsEve2018();
        LocalDate newYearsEve2019 = newYearsEve.withYear(2019); // change the newYearsEve using the with method
        LocalDate firstJanuary = newYearsEve.withDayOfYear(1);
        assertThat(2019, equalTo(newYearsEve2019.getYear()));
        assertThat(1, equalTo(firstJanuary.getDayOfMonth()));
    }

    @Test
    public void shouldAdjustToNewYearsEve(){
        LocalDate firstOfDecember = LocalDate.of(2017,12,1);
        LocalDate newYearsEve = firstOfDecember.with(TemporalAdjusters.lastDayOfMonth()); // write a temporal adjuster to ajust the firstOfDecember to new years eve
        assertThat(newYearsEve.getYear(), is(equalTo(2017)));
        assertThat(newYearsEve.getMonth(), is(equalTo(Month.DECEMBER)));
        assertThat(newYearsEve.getDayOfMonth(), is(equalTo(31)));
        //DONE
    }

    @Test
    public void shouldFindTheNextFriday13th() {
        LocalDate from = LocalDate.of(2017, JANUARY, 1);
        LocalDate expected = LocalDate.of(2017, JANUARY, 13);
        assertEquals(expected, DateTime8.findNextFriday13th(from));
    }
}
