package vn.ryan.entity.core.dto.edupia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserProfileRequest {
    @JsonProperty("full_name")
    private String fullName;
    private String address;
    private String school;
    @JsonProperty("birth_day")
    private String birthDay;
    private Integer gender;
    private String email;
    private Integer grade;
    @JsonProperty("image_url")
    private String imageUrl;
}
