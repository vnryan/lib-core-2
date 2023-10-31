package vn.ryan.core.model.zalo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Recipient {
    @JsonProperty("user_id")
    private String userId;
}
