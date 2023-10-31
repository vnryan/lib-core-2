package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOtpResetPasswordResponse extends BaseEdupiaResponse {
    private Object data;
}
