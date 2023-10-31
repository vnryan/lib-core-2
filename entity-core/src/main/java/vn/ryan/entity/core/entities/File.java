package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emc_files")
public class File extends BaseEntity {
    private String name;
    private String description;
    /**
     * 'Image':1
     * 'Video': 2
     * 'Audio':3
     * 'PDF':4
     */
    private Integer type;
    @Column(name = "path_file")
    private String pathFile;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "upadted_at")
    private Date updatedAt;
}
