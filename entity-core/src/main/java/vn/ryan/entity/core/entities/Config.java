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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emc_config")
public class Config extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    @Column(name = "key")
    private String key;
    @Column(name = "value")
    private String value;
    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private Integer status;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;
    @Column(name = "image")
    private String image;
}
