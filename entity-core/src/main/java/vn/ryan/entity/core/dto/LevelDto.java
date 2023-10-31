package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Integer id;
    private String name;
}
