package vn.ryan.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class AppUtils {

    private AppUtils() {}

    public static String getFullStackTraceRaw(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    public static String getFullStackTrace(Exception e) {
        return "(getFullStackTrace)" + getFullStackTraceRaw(e);
    }
}
