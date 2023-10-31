package vn.ryan.entity.core.dto.math;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterConsultReq {
    private String phone;
    private String name;
    private String course;
    private Integer gradeId;
}
