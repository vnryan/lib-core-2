package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "emc_unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private String name;
    private String slug;
    @Column(name = "name_en")
    private String nameEn;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "is_free")
    private Integer isFree;
    private Integer type;
    @Column(name = "course_id")
    private Long courseId;
    private Integer num;
    private String image;
    @Column(name = "title_seo")
    private String titleSeo;
    @Column(name = "desc_seo")
    private String descSeo;
    private String description;
    private Integer duration;
    @Column(name = "number_of_questions")
    private Integer numberOfQuestions;
    @Column(name = "max_attemps_allowed")
    private Integer maxAttempsAllowed;
    private String pdf;
    @Column(name = "type_exam")
    private Integer typeExam;
    @Column(name = "book_exam")
    private String bookExam;
    private Integer semester;
    private Integer level;
    @Column(name = "type_program")
    private Integer typeProgram;
    @Column(name = "month_test")
    private Integer monthTest;
}
