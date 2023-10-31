package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "emc_teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    private String slug;
    @Column(name = "is_active")
    private Integer isActive;
    private String experience;
    private Integer num;
    private Integer isHot;
    private Integer role;
    private String job;
    private String image;
    @Column(name = "image_app")
    private String imageApp;
    @Column(name = "signature_image")
    private String signatureImage;
    private String description;
}
