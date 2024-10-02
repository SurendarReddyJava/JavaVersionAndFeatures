This example covers the following:

**LocalDate**: Demonstrates how to get the current date and a specific date.

**LocalTime**: Shows how to get the current time and a specific time.

**LocalDateTime**: Combines date and time without timezone information.

**ZonedDateTime**: Combines date and time with timezone information.

**Instant**: Represents a point in time with nanosecond precision.

**Duration**: Represents a time-based amount of time.

**Period**: Represents a date-based amount of time.

**DateTimeFormatter**: Formats date-time objects into a specific pattern...



Java 8 introduced a new Date and Time API in the `java.time` package to address the shortcomings of the old `java.util.Date` and `java.util.Calendar` classes. Here are the key features and classes added:

### Key Features

1. **Immutability and Thread-Safety**:
   - The new Date and Time API is immutable and thread-safe, unlike the old `java.util.Date` and `java.util.Calendar` classes.

2. **Fluent API**:
   - The new API provides a fluent interface, making it easier to chain method calls and perform complex date-time operations.

3. **ISO-Centric**:
   - The new API follows ISO-8601 standards for date and time representation, ensuring consistency and interoperability.

### Key Classes

1. **`LocalDate`**:
   - Represents a date (year, month, day) without time or timezone information.
   ```java
   LocalDate date = LocalDate.now();
   LocalDate specificDate = LocalDate.of(2024, Month.OCTOBER, 2);
   ```

2. **`LocalTime`**:
   - Represents a time (hour, minute, second, nanosecond) without date or timezone information.
   ```java
   LocalTime time = LocalTime.now();
   LocalTime specificTime = LocalTime.of(7, 34, 22);
   ```

3. **`LocalDateTime`**:
   - Combines date and time without timezone information.
   ```java
   LocalDateTime dateTime = LocalDateTime.now();
   LocalDateTime specificDateTime = LocalDateTime.of(2024, Month.OCTOBER, 2, 7, 34, 22);
   ```

4. **`ZonedDateTime`**:
   - Combines date and time with timezone information.
   ```java
   ZonedDateTime zonedDateTime = ZonedDateTime.now();
   ZonedDateTime specificZonedDateTime = ZonedDateTime.of(specificDateTime, ZoneId.of("Asia/Kolkata"));
   ```

5. **`Instant`**:
   - Represents a point in time (timestamp) with nanosecond precision.
   ```java
   Instant instant = Instant.now();
   Instant specificInstant = Instant.ofEpochSecond(1609459200);
   ```

6. **`Duration`**:
   - Represents a time-based amount of time, such as '34.5 seconds'.
   ```java
   Duration duration = Duration.ofHours(5);
   Duration between = Duration.between(specificTime, time);
   ```

7. **`Period`**:
   - Represents a date-based amount of time, such as '2 years, 3 months, and 4 days'.
   ```java
   Period period = Period.ofYears(2);
   Period between = Period.between(specificDate, date);
   ```

8. **`DateTimeFormatter`**:
   - Used for formatting and parsing date-time objects.
   ```java
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
   String formattedDateTime = dateTime.format(formatter);
   ```

### Additional Classes and Utilities

- **`Year`, `YearMonth`, `MonthDay`**:
  - Represent specific parts of a date, such as a year, a combination of year and month, or a combination of month and day.
  ```java
  Year year = Year.now();
  YearMonth yearMonth = YearMonth.now();
  MonthDay monthDay = MonthDay.now();
  ```

- **`Clock`**:
  - Provides access to the current instant, date, and time using a time-zone.
  ```java
  Clock clock = Clock.systemDefaultZone();
  Instant instant = clock.instant();
  ```

- **`ZoneId` and `ZoneOffset`**:
  - Represent time-zone identifiers and offsets from UTC.
  ```java
  ZoneId zoneId = ZoneId.of("Asia/Kolkata");
  ZoneOffset zoneOffset = ZoneOffset.of("+05:30");
  ```

- **`TemporalAdjusters`**:
  - Provide utility methods for date-time adjustments, such as finding the next or previous day of the week.
  ```java
  LocalDate nextSunday = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
  ```

