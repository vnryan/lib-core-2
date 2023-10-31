package vn.ryan.core.model.zalo;

import lombok.Data;

@Data
public class ZaloSendMessageRequest {
    private Recipient recipient;
    private Message message;
}
