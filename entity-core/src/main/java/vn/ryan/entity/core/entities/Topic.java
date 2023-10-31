package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emc_topic")
public class Topic extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    private String slug;
    @Column(name = "is_active")
    private Integer isActive;
    private String description;
    private Integer gradeId;
}
