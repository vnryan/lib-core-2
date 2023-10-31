package vn.ryan.entity.core.dto.edupia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOtpResetPasswordRequest {
    private String phone;
    @JsonProperty("username")
    private String userName;
}
