package vn.ryan.document.core.model;

import lombok.Data;

import java.util.List;

@Data
public class ReportLessons {
    private Long id;
    private Long unitId;
    private String name;
    /** Điểm luyện tập */
    private Double avgPoint;
    /** Nhận xét mặc định khi không có điểm mạnh */
    private String defaultCmtStrong;
    /** Nhận xét mặc định khi không có điểm yếu */
    private String defaultCmtWeak;
    private List<ReportSkills> skills;
}
