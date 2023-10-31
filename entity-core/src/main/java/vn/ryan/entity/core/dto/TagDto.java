package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String description;
    private Integer isActive = 1;
    private Date createdAt;
    private Date updatedAt;
}
