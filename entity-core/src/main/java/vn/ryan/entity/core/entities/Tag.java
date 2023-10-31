package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emc_tags")
public class Tag extends BaseEntity {
    private String name;
    private String description;
    @Column(name = "is_active")
    private Integer isActive;
}
