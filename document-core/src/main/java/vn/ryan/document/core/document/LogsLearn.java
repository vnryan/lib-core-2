package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.core.constants.DeviceType;
import vn.ryan.core.constants.LearnStatus;
import vn.ryan.core.constants.PartType;
import vn.ryan.document.core.model.Answers;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "logs_learn")
public class LogsLearn extends BaseDocument {
    private boolean isTest;
    private Integer courseType;
    private Long lessonId;
    private Long courseId;
    private Long unitId;
    private Long userId;
    private String phone;
    private String userName;
    //diem lam bai luyen tap (part) = trung binh ex
    private Double point;
    //loai part: video, game, ex, home
    private PartType exerciseType;
    private Long liveClassId;
    private String liveClassUid;
    private Long exerciseId;
    private DeviceType source;
    private LearnStatus learnStatus = LearnStatus.DONE;

    private List<Answers> steps;
}
