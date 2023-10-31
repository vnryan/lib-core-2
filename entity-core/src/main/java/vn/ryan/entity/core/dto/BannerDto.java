package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String description;
    private Integer channel;
    private String image;
    private String imageMobile;
    private String imageTablet;
    private String link;
    private Integer status;
    private Integer type;
    private Integer isActive;
    private Date createdAt;
    private Date updatedAt;
}
