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
public class UnitDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private Integer isActive = 1;
    private Integer isFree;
    private Integer type;
    private Long courseId;
    private Integer num;
    private String image;
    private String description;
    private Integer monthTest;
    private Integer level;
    private Integer typeProgram;
    private Date createdAt;
    private Date updatedAt;

    private List<LessonDto> lessons;
}
