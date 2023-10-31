package vn.ryan.document.core.model;

import lombok.Data;

import java.util.Map;

@Data
public class ReportWeeklyTotalLesson {
    private String userName;
    private String courseName;
    private Map<String, Integer> dataCountLesson;
}
