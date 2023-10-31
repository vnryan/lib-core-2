package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private Long userId;
    private Integer gradeId;
    private Integer levelId;
    private String name;
    private Integer gender;
    private String dateBirth;
    private String email;
    private String phone;
    private String userName;
    private Integer isActive = 1;
    private String note;
    private String parentName;
    private String deviceId;
    private String deviceType;
    private String version;
    private String avatar;
    private String activeCode;
    private String phoneZalo;
    private Date createdAt;
    private Date updatedAt;
    private CourseDto courses;
}
