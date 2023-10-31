package vn.ryan.entity.core.dto.edupia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseInfoRequest {
    @JsonProperty("exercise_id")
    private Long exerciseId;
    private Boolean randomQuestions;
    private Long lessonId;

    public ExerciseInfoRequest(
            Long exerciseId,
            Boolean randomQuestions
    ) {
        this.exerciseId = exerciseId;
        this.randomQuestions = randomQuestions;
    }
}
