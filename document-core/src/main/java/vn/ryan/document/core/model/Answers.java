package vn.ryan.document.core.model;

import lombok.Data;

import java.util.Map;

@Data
public class Answers {
    private Long questionId;
    private Double point;
    private Integer questionType;
    private Map<String, Object> answers;
}
