package vn.ryan.document.core.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.core.constants.ReportType;
import vn.ryan.document.core.model.AverageOfWeek;
import vn.ryan.document.core.model.ReportLessons;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "report")
public class Report extends BaseDocument {
    private ReportType reportType;
    private String userName;
    private String name;
    private Integer gradeId;
    private Long courseId;
    private Long teacherId;
    private String teacherName;
    private String signatureImage;
    private String position;
    /**
     * week of year
     */
    private Integer weekly;
    private Integer month;
    private Integer year;
    /** Số bài cần học */
    private Integer numLessonToLearn;
    /** Số bài hoàn thành */
    private Integer numLessonComplete;
    /** Số bài đang thực hiện */
    private Integer numLessonProcess;
    private List<ReportLessons> lessons;
    private List<AverageOfWeek> averageOfWeek;
    private String startDate;
    private String endDate;
    private String studentAvatar;
    private String teacherAvatar;
    private String teacherAppAvatar;
}
