package vn.ryan.core.model.zalo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {
    private String text;
    @JsonProperty("msg_id")
    private String msgId;
}
