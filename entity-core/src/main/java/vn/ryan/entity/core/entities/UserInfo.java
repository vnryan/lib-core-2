package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Table save information user for app
 * grade, level
 */
@Entity
@Table(name = "em_user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "grade_id")
    private Integer gradeId;
    @Column(name = "level_id")
    private Integer levelId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "date_birth")
    private String dateBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "username")
    private String userName;
    @Column(name = "is_active")
    private Integer isActive;
    private String note;
    @Column(name = "parent_name")
    private String parentName;
    @Column(name = "device_id")
    private String deviceId;
    @Column(name = "device_type")
    private String deviceType;
    private String version;
    private String avatar;
    private String address;
    private String school;
    @Column(name = "active_code")
    private String activeCode;
    @Column(name = "phone_zalo")
    private String phoneZalo;
    @Column(name = "username_2")
    private String userName2;

}
