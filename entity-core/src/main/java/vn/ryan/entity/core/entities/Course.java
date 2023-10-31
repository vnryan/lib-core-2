package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emc_course")
public class Course extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    private String slug;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "grade_id")
    private Integer gradeId;
    @Column(name = "level_id")
    private Integer levelId;
    @Column(name = "teacher_id")
    private Long teacherId;
    private String description;
    private String intro;
}
