package vn.ryan.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainTest {

    public static void main(String[] args) {
        Calendar aNotGMTCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        System.out.println(aNotGMTCalendar.getTime());

        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(dateFormatGmt.format(new Date()));
    }
}
