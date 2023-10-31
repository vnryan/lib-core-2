package vn.ryan.entity.core.dto.edupia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {
    @JsonProperty("current_password")
    private String currentPassword;
    @JsonProperty("new_password")
    private String newPassword;
}
