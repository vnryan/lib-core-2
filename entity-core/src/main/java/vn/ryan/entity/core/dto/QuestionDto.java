package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
    private String name;
    private String title;
    private String shortDescription;
    private String thumbnail;
    private String tag;
    private String questionContent;
    private String answers;
    private String metaDataVersion;
    private String responseInteractionType;
    private Integer platformId;
    private Integer isActive = 1;
    private String createdBy;
    private Date createdAt;
    private Date updatedAt;
}
