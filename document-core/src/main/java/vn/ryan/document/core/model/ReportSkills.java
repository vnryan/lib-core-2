package vn.ryan.document.core.model;

import lombok.Data;

@Data
public class ReportSkills {
    private Integer type;
    private String name;
    private Double point;
    /** Nhận xét
     * 1. NEED_TO_IMPROVE
     * 2. STRENGTH
     * 3. POWERFUL
     * */
    private Integer commentType;
    /** Nhận xét */
    private String comment;
}
