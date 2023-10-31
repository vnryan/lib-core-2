package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emc_grades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    private Integer id;
    private String name;
    @Column(name = "app_image")
    private String appImage;
    @Column(name = "web_image")
    private String webImage;
    @Column(name = "is_active")
    private Integer isActive;
}
