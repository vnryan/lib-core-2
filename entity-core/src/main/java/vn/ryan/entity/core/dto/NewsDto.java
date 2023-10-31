package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String slug;
    private String title;
    private String personName;
    private String job;
    private String description;
    private String content;
    private String image;
    private String link;
    private Integer num;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "is_hot")
    private Integer isHot;
    @Column(name = "home_page")
    private Integer homePage;
    private Integer status;
    private Integer type;
    private Long createdUser;
    private Date createdAt;
    private Date updatedAt;
}
