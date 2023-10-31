package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportSkillDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Integer type;
    private String name;
    private Double point;
    /**
     * Nhận xét
     * 1. NEED_TO_IMPROVE
     * 2. STRENGTH
     * 3. POWERFUL
     */
    private Integer commentType;
    /**
     * Nhận xét
     */
    private String comment;
}
