package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.ryan.core.constants.LearnStatus;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private Integer isActive = 1;
    private Integer isFree;
    private UnitDto unit;
    private Long unitId;
    private Long courseId;
    private String description;
    private Integer position;
    private String image;
    private Date createdAt;
    private Date updatedAt;

    private LearnStatus status = LearnStatus.OPEN;

    private List<ExerciseDto> exercises;
}
