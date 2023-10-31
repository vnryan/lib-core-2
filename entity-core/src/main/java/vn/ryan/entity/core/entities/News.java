package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "emc_news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    private String slug;
    private String title;
    @Column(name = "person_name")
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
    @Column(name = "created_user")
    private Long createdUser;
}
