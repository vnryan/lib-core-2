package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonExerciseDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private Long lessonId;
    private Long exerciseId;
    private Integer position;
    private Date createdAt;
    private Date updatedAt;
}
