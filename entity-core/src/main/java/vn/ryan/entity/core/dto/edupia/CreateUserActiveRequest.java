package vn.ryan.entity.core.dto.edupia;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserActiveRequest {
    private String username;
    private String password;
    private String deviceId;
    private Integer grade;
    private String phone;
    @JsonProperty("clienttype")
    private String clientType;
    private String code;
    private List<Integer> productType;
}
