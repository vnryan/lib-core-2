package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.ryan.core.constants.LearnStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private LearnStatus status = LearnStatus.OPEN;
    private Integer position;
    private Object detail;
    private Double maxPoint = 0D;

    public ExerciseDto(Long id) {
        this.id = id;
    }
}
