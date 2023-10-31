package vn.ryan.entity.core.dto.firebase;

import lombok.Data;

import java.util.Map;

@Data
public class FireBaseNotificationRequest {
    private Map<String, Object> message;
}
