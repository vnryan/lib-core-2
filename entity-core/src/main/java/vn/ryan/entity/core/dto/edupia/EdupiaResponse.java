package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EdupiaResponse extends BaseEdupiaResponse {
    private Object data;
}
