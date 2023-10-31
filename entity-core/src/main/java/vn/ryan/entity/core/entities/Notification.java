package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.ryan.core.constants.NotificationStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "emc_notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    private String title;
    private String content;
    private String link;
    private String date;
    private String time;
    @Column(name = "is_active")
    private Integer isActive;
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
    @Column(name = "created_user")
    private Long createdUser;
}
