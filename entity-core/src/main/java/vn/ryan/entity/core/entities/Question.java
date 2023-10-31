package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "emc_questions")
public class Question extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "tag")
    private String tag;
    @Column(name = "question_content")
    private String questionContent;
    @Column(name = "answers")
    private String answers;
    @Column(name = "metadata_version")
    private String metaDataVersion;
    @Column(name = "response_interaction_type")
    private String responseInteractionType;
    @Column(name = "platform_id")
    private Integer platformId;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "created_by")
    private String createdBy;
}
