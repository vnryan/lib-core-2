package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEdupiaResponse {
    private Integer errorCode;
    private String message;
    private String stack;
    public BaseEdupiaResponse(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
