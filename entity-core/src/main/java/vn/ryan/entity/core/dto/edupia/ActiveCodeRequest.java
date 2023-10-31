package vn.ryan.entity.core.dto.edupia;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveCodeRequest {
    private Integer grade;
    private String code;
    private List<Integer> productType;
}
