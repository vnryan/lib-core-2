package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String description;
    /**
     * 'Image':1
     * 'Video': 2
     * 'Audio':3
     * 'PDF':4
     */
    private Integer type;
    private String pathFile;
    private Integer isActive;
    private Date createdAt;
    private Date updatedAt;
}
