package com.soori.java8.datetime;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // LocalDate example
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2024, Month.OCTOBER, 2);
        System.out.println("Today's date: " + today);
        System.out.println("Specific date: " + specificDate);

        // LocalTime example
        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(7, 34, 22);
        System.out.println("Current time: " + now);
        System.out.println("Specific time: " + specificTime);

        // LocalDateTime example
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime specificDateTime = LocalDateTime.of(2024, Month.OCTOBER, 2, 7, 34, 22);
        System.out.println("Current date and time: " + dateTime);
        System.out.println("Specific date and time: " + specificDateTime);

        // ZonedDateTime example
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime specificZonedDateTime = ZonedDateTime.of(specificDateTime, ZoneId.of("Asia/Kolkata"));
        System.out.println("Current date and time with timezone: " + zonedDateTime);
        System.out.println("Specific date and time with timezone: " + specificZonedDateTime);

        // Instant example
        Instant instant = Instant.now();
        Instant specificInstant = Instant.ofEpochSecond(1609459200);
        System.out.println("Current instant: " + instant);
        System.out.println("Specific instant: " + specificInstant);

        // Duration example
        Duration duration = Duration.ofHours(5);
        Duration betweenTimes = Duration.between(specificTime, now);
        System.out.println("Duration of 5 hours: " + duration);
        System.out.println("Duration between specific time and now: " + betweenTimes);

        // Period example
        Period period = Period.ofYears(2);
        Period betweenDates = Period.between(specificDate, today);
        System.out.println("Period of 2 years: " + period);
        System.out.println("Period between specific date and today: " + betweenDates);

        // DateTimeFormatter example
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Formatted current date and time: " + formattedDateTime);
    }
}
