package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.document.core.model.ReportLessons;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "report_weekly")
public class ReportWeekly extends BaseDocument {
    private String userName;
    private Long courseId;
    private Long teacherId;
    private String teacherName;
    private String signatureImage;
    private Integer weekly;
    private Integer year;
    /** Số bài cần học */
    private Integer numLessonToLearn;
    /** Số bài hoàn thành */
    private Integer numLessonComplete;
    /** Số bài đang thực hiện */
    private Integer numLessonProcess;
    private List<ReportLessons> lessons;
}
