package vn.ryan.entity.core.dto.edupia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserActiveData {
    private Integer dayVip;
    @JsonProperty("access_token")
    private String accessToken;
    private String notify;
    private String notifyWeb;
}
