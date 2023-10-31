package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emc_lessons")
public class Lesson extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    @Column(name = "name")
    private String name;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "is_free")
    private Integer isFree;
    @Column(name = "unit_id")
    private Long unitId;
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "description")
    private String description;
    private Integer position;

}
