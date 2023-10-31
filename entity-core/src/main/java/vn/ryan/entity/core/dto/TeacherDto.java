package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String slug;
    private Integer isActive;
    private Integer isHot;
    private String experience;
    private Integer num;
    private Integer role;
    private String job;
    private String image;
    private String imageApp;
    private String signatureImage;
    private String description;
    private String roleName;
    private Date createdAt;
    private Date updatedAt;
}
