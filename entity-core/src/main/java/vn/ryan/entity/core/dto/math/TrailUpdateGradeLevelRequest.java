package vn.ryan.entity.core.dto.math;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrailUpdateGradeLevelRequest {
    private String phone;
    private Integer gradeId;
    private Integer levelId;
}
