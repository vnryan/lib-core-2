package vn.ryan.core.utils;

import vn.ryan.core.constants.NotificationTopic;
import vn.ryan.core.constants.ReportComment;
import vn.ryan.core.constants.ReportForm;

import java.util.Map;

public class StringUtils {
    public static String getReportForm(Integer type) {
        switch (type) {
            case 1:
                return ReportForm.REMEMBER_KNOWLEDGE.getValues();
            case 2:
                return ReportForm.UNDERSTAND_KNOWLEDGE.getValues();
            case 3:
                return ReportForm.APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES.getValues();
            case 4:
                return ReportForm.APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES.getValues();
            case 5:
                return ReportForm.APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES.getValues();
            default:
                return null;
        }
    }

    public static Integer getReportCommentType(Double point) {
        if (point <= 5.0D) {
            return 1;
        } else {
            return 5.0D < point && point <= 8.0D ? 2 : 3;
        }
    }

    public static String getReportComment(Double point, Integer type) {
        switch (type) {
            case 1:
                if (point <= 5) {
                    return ReportComment.REMEMBER_KNOWLEDGE_NEED_TO_IMPROVE.getValues();
                } else if (5 < point && point <= 8) {
                    return ReportComment.REMEMBER_KNOWLEDGE_STRENGTH.getValues();
                } else {
                    return ReportComment.REMEMBER_KNOWLEDGE_POWERFUL.getValues();
                }
            case 2:
                if (point <= 5) {
                    return ReportComment.UNDERSTAND_KNOWLEDGE_NEED_TO_IMPROVE.getValues();
                } else if (5 < point && point <= 8) {
                    return ReportComment.UNDERSTAND_KNOWLEDGE_STRENGTH.getValues();
                } else {
                    return ReportComment.UNDERSTAND_KNOWLEDGE_POWERFUL.getValues();
                }
            case 3:
                if (point <= 5) {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES_NEED_TO_IMPROVE.getValues();
                } else if (5 < point && point <= 8) {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES_STRENGTH.getValues();
                } else {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_SIMPLE_EXERCISES_POWERFUL.getValues();
                }
            case 4:
                if (point <= 5) {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES_NEED_TO_IMPROVE.getValues();
                } else if (5 < point && point <= 8) {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES_STRENGTH.getValues();
                } else {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_COMPLEX_EXERCISES_POWERFUL.getValues();
                }
            case 5:
                if (point <= 5) {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES_NEED_TO_IMPROVE.getValues();
                } else if (5 < point && point <= 8) {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES_STRENGTH.getValues();
                } else {
                    return ReportComment.APPLYING_KNOWLEDGE_TO_SOLVE_ADVANCED_EXERCISES_POWERFUL.getValues();
                }
            case 6:
                return ReportComment.DEFAULT_STRONG.getValues();
            case 7:
                return ReportComment.DEFAULT_WEAK.getValues();
            default:
                return null;
        }
    }

    public static String getGradeName(Integer gradeId) {
        switch (gradeId) {
            case 1:
                return "Lớp 1";
            case 2:
                return "Lớp 2";
            case 3:
                return "Lớp 3";
            case 4:
                return "Lớp 4";
            case 5:
                return "Lớp 5";
            case 6:
                return "Lớp 6";
            case 7:
                return "Lớp 7";
            case 8:
                return "Lớp 8";
            case 9:
                return "Lớp 9";
            default:
                return "Not define";
        }
    }

    public static String getRoleNameTeacher(Integer role) {
        switch (role) {
            case 1:
                return "Cố vấn nội dung";
            case 2:
                return "Giáo viên giảng dạy";
            default:
                return "Not define";
        }
    }

    public static String getNotificationGroup(String userName, Integer gradeId, Integer levelId) {
        if (userName == null || "".equals(userName)) {
            return NotificationTopic.TRIAL_TOPIC.getValues();
        }

        if (gradeId != null && levelId == null) {
            return NotificationTopic.NOT_TEST_TOPIC.getValues();
        }

        if (gradeId != null) {
            return NotificationTopic.GRADE_LEVEL_TOPIC.getValues() + "-" + gradeId + "-" + levelId;
        }
        return null;
    }

    public static String buildParam(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return null;
        }
        var query = new StringBuilder();
        for (var entry : params.entrySet()) {
            query.append(entry.getKey()).append("=").append(ConvertUtils.toStringJson(entry.getValue())).append("&");
        }
        return query.toString();
    }

    public static String buildCronByDateAndTime(String date, String time) {
        var cronStr = "";
        String[] dateArr = date.split("/");
        String[] timeArr = time.split(":");
        cronStr = "00 " + timeArr[1] + " " + timeArr[0] + " " + dateArr[0] + " " + dateArr[1] + " ?";
        return cronStr;
    }

    /**
     * convert form
     *
     * @param phone String
     * @return String
     */
    public static String getPhone(String phone) {
        return 0 + phone.substring(2);
    }
}
