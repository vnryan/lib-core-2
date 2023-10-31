package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportWeeklyDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String userName;
    private Integer weekly;
    private Integer year;
    /**
     * Số bài cần học
     */
    private Integer numLessonToLearn;
    /**
     * Số bài hoàn thành
     */
    private Integer numLessonComplete;
    private List<ReportLessonDto> lessons;
}
