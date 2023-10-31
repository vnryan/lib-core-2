package vn.ryan.core.model.zalo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ZaloOaEvent {
    @JsonProperty("oa_id")
    private String oaId;
    private Follower follower;
    @JsonProperty("event_name")
    private String eventName;
    @JsonProperty("app_id")
    private String appId;
    private Sender sender;
    private Recipient recipient;
    private Message message;
    @JsonProperty("user_id_by_app")
    private String userIdByApp;
    private String source;
}
