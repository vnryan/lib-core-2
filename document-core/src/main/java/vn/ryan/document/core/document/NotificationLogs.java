package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.core.constants.NotificationStatus;
import vn.ryan.core.constants.NotificationType;

import java.util.Set;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "notification_logs")
public class NotificationLogs extends BaseDocument {
    private String deviceId;
    private Set<String> deviceIds;
    private String userName;
    private String phone;
    private Long userId;
    private Long userInfoId;
    private String title;
    private String content;
    private String image;
    private String topic;
    private Integer gradeId;
    private Integer levelId;
    private String uuid = UUID.randomUUID().toString();
    private NotificationType type;
    /**
     * 0 -> unread
     * 1 -> read
     */
    private Integer isRead = 0;
    private Integer month;
    private Integer year;
    private String group;
    private NotificationStatus status = NotificationStatus.SEND;
}
