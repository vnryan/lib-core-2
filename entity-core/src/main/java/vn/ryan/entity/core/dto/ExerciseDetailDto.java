package vn.ryan.entity.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExerciseDetailDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    @JsonProperty("excercise")
    private Object exercise;
}
