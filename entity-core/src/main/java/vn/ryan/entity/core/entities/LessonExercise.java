package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emc_lesson_exercise")
public class LessonExercise extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    @Column(name = "lesson_id")
    private Long lessonId;
    @Column(name = "exercise_id")
    private Long exerciseId;
    private Integer position;
}
