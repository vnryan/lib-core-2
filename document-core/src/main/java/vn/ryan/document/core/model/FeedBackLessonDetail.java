package vn.ryan.document.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.ryan.core.constants.FeedBackLessonType;

@EqualsAndHashCode(callSuper = true)
@Data
public class FeedBackLessonDetail extends FeedbackDetail {
    private Long lessonId;
    private Long exerciseId;
    private Long timeVideo;
    private String notes;
    private FeedBackLessonType feedbackType;
}
