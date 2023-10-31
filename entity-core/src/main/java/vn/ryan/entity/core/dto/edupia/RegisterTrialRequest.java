package vn.ryan.entity.core.dto.edupia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTrialRequest {
    private String parentName;
    private String phone;
    private String deviceId;
    @JsonProperty("devicetype")
    private String deviceType;
    private String version;
    private Integer gradeId;
    private Integer levelId;
}
