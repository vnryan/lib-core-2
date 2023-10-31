package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String slug;
    private Integer isActive = 1;
    private Integer gradeId;
    private Integer levelId;
    private String description;
    private String intro;
    private Long teacherId;
    private Date createdAt;
    private Date updatedAt;

    private List<UnitDto> units;
    private TeacherDto teacherDto;
}
