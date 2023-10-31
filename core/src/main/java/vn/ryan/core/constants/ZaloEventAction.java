package vn.ryan.core.constants;

public enum ZaloEventAction {
    MATH_REPORT_WEEKLY("#mathReportWeekly"),
    MATH_REPORT_LAST_WEEKLY("#mathReportLastWeek"),
    MATH_REPORT_MONTHLY("#mathReportMonthly"),
    MATH_EDU_MAT("#MATH:");
    private final String values;

    ZaloEventAction(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }

}
