package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "emc_banner")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private Long id;
    private String name;
    private String description;
    private Integer channel;
    private String image;
    @Column(name = "image_mobile")
    private String imageMobile;
    @Column(name = "image_tablet")
    private String imageTablet;
    private String link;
    private Integer status;
    private Integer type;
    private Integer position;
    @Column(name = "is_active")
    private Integer isActive;
}
