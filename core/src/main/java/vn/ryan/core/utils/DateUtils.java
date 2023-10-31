package vn.ryan.core.utils;

import vn.ryan.core.constants.AppConstants;
import vn.ryan.core.constants.TimeType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.*;

public class DateUtils {

    private DateUtils() {
    }

    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 2022-06-13
     *
     * @param date yyyy-MM-dd
     * @return LocalDate
     */
    public static java.sql.Date toDate(String date, String format) {
        if (date == null || "".equals(date) || format == null || "".equals(format)) return null;
        //"dd/MM/yyyy HH:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return new java.sql.Date(sdf.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date toDate(Long date) {
        if (date == null) return null;
        if (date < 10000000000L) {
            return new Date(date * 1000);
        }
        return new Date(date);
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) return null;
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date) {
        if (date == null) return null;
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * 2022-06-13
     *
     * @param date yyyy-MM-dd
     * @return LocalDate
     */
    public static LocalDate toLocalDate(String date) {
        if (date == null) return null;
        return LocalDate.parse(date);
    }

    public static Integer weekOfYear(LocalDate date) {
        return date.get(WeekFields.of(Locale.getDefault()).weekOfYear());
    }

    /**
     * @param date Integer yyyyMM
     * @return LocalDate
     */
    public static LocalDate firstDayOfMonth(Integer date) {
        if (200000 < date && date < 399999) {
            var year = date / 100;
            var month = date % 100;
            return LocalDate.of(year, month, 1);
        }
        var dateNow = LocalDate.now();
        return LocalDate.of(dateNow.getYear(), dateNow.getMonthValue(), 1);
    }

    /**
     * @param month Integer
     * @param year  Integer
     * @return List<Integer>
     */
    public static List<Integer> listWeekOfMonth(Integer month, Integer year) {
        if (month == null || year == null) return Collections.emptyList();
        var listWeekOfYear = new ArrayList<Integer>();
        var firstDay = LocalDate.of(year, month, 1);
        var lastDay = firstDay.plusMonths(1).minusDays(1);
        var lastDayString = toDateFormat(lastDay, AppConstants.DATE_MONTH_FORMAT);
        if (lastDayString == null) return Collections.emptyList();
        var lastDayInt = Integer.parseInt(lastDayString);
        for (int i = 0; i <= 5; i++) {
            var dateString = toDateFormat(firstDay, AppConstants.DATE_MONTH_FORMAT);
            if (dateString == null) return Collections.emptyList();
            var dateInt = Integer.parseInt(dateString);
            if (dateInt <= lastDayInt) {
                listWeekOfYear.add(weekOfYear(firstDay));
                firstDay = firstDay.plusWeeks(1);
            }
        }
        return listWeekOfYear;
    }

    /**
     * @param date Integer yyyyMM
     * @return LocalDate
     */
    public static LocalDate lastDayOfMonth(Integer date) {
        if (date == null) return null;
        var firstDayOfMonth = firstDayOfMonth(date);
        return firstDayOfMonth.plusMonths(1).minusDays(1);
    }

    public static LocalDate firstMondayOfMonth(LocalDate date) {
        if (date == null) return null;
        return date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    public static LocalDate firstDayOfWeek(LocalDate date) {
        if (date == null) return null;
        return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }

    public static LocalDate lastDayOfWeek(LocalDate date) {
        if (date == null) return null;
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    }

    public static String startOfDay(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_2);
        LocalDateTime startOfDay = date.atTime(LocalTime.MIN);
        return startOfDay.format(fmt2);
    }

    public static String endOfDay(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_2);
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return endOfDay.format(fmt2);
    }

    public static String toDateFormat(LocalDateTime date, String format) {
        if (date == null) return null;
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern(format);
        return date.format(fmt2);
    }

    public static String toDateFormat(LocalDate date, String format) {
        if (date == null) return null;
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern(format);
        return date.format(fmt2);
    }

    public static String toDateFormat(Date date, String format) {
        if (date == null) return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Boolean gtNow(String date) throws ParseException {

        LocalDateTime now = LocalDateTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT_1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_1);
        String formatDateTime = now.format(formatter);

        Date date1 = sdf.parse(date);
        Date date2 = sdf.parse(formatDateTime);

        return date1.after(date2);
    }

    public static Boolean gtNowFiveMinutes(String date, LocalDateTime now) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT_1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_1);
        String plusFiveMinutes = now.plusMinutes(5).format(formatter);
        String minusThreeSecond = now.minusSeconds(3).format(formatter);

        Date date1 = sdf.parse(date);
        Date date2 = sdf.parse(plusFiveMinutes);
        Date date3 = sdf.parse(minusThreeSecond);

        return (date1.after(date3) || date1.equals(date3)) && date1.before(date2);
    }

    public static Boolean gtDateNow(String date, String time) {
        if (date == null || time == null) {
            return false;
        }
        try {
            var datePair = date.trim() + " " + time.trim();
            LocalDateTime now = LocalDateTime.now();
            SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT_1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_1);
            String formatDateTime = now.format(formatter);

            Date date1 = sdf.parse(datePair);
            Date date2 = sdf.parse(formatDateTime);

            return date1.after(date2);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * @param date      Ngày cần kiểm tra
     * @param time      Thời gian cần check
     * @param totalTime Time bị trừ đi tại thời điểm hiện tại
     * @return true nếu thời điểm kiểm tra < thời điểm check
     */
    public static Boolean gtTime(String date, String time, Integer totalTime, TimeType type) {
        if (date == null || time == null || totalTime == null) {
            return false;
        }
        try {
            var datePair = date.trim() + " " + time.trim();
            var now = plusTime(LocalDateTime.now(), totalTime, type);
            var sdf = new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT_1);
            var formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_1);
            var formatDateTime = now.format(formatter);

            Date date1 = sdf.parse(datePair);
            Date date2 = sdf.parse(formatDateTime);
            return date1.after(date2);
        } catch (Exception ex) {
            return false;
        }
    }

    public static LocalDateTime minusTime(LocalDateTime date, Integer totalTime, TimeType type) {
        switch (type) {
            case DAY:
                return date.minusDays(totalTime);
            case HOUR:
                return date.minusHours(totalTime);
            case MINUTE:
                return date.minusMinutes(totalTime);
            default:
                return date.minusSeconds(totalTime);
        }
    }

    public static LocalDateTime plusTime(LocalDateTime date, Integer totalTime, TimeType type) {
        switch (type) {
            case DAY:
                return date.plusDays(totalTime);
            case HOUR:
                return date.plusHours(totalTime);
            case MINUTE:
                return date.plusMinutes(totalTime);
            default:
                return date.plusSeconds(totalTime);
        }
    }

    public static Boolean gtNow(LocalDateTime date) {
        if (date == null) {
            return false;
        }
        try {
            var now = LocalDateTime.now();
            var sdf = new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT_1);
            var formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_1);
            var formatDateTime = now.format(formatter);
            var datePair = date.format(formatter);

            Date date1 = sdf.parse(datePair);
            Date date2 = sdf.parse(formatDateTime);
            return date1.after(date2);
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * convert time to second
     *
     * @param time time format hh:mm:ss
     * @return long => secound
     */
    public static Integer timeToSecond(String time) {
        if (time == null || "".equals(time)) return 0;
        try {
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 3600 + Integer.parseInt(times[1]) * 60 + Integer.parseInt(times[2]);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Boolean gtNow(Date date1) {
        if (date1 == null) {
            return false;
        }
        try {
            var now = LocalDateTime.now();
            var sdf = new SimpleDateFormat(AppConstants.DATE_TIME_FORMAT_1);
            var formatter = DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT_1);
            var formatDateTime = now.format(formatter);
            Date date2 = sdf.parse(formatDateTime);
            return date1.after(date2);
        } catch (Exception ex) {
            return false;
        }
    }
}
