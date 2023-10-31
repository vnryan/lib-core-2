package vn.ryan.entity.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import vn.ryan.core.constants.LiveClassStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emc_live_class")
public class LiveClass extends BaseEntity {
    @Column(name = "course_id")
    private Long courseId;
    @Column(name = "grade_id")
    private Long gradeId;
    private String name;
    /**
     * Ngày bắt đầu
     */
    private String date;
    /**
     * thời gian bắt đầu
     */
    private String time;
    @Column(name = "seeding_time")
    private String seedingTime;
    @Column(name = "start_time")
    private Timestamp startTime;
    /**
     * link other app
     */
    private String link;
    /**
     * tổng thời gian live class
     */
    @Column(name = "video_time")
    private String videoTime;
    private String teacher;
    private String image;
    @Enumerated(EnumType.STRING)
    private LiveClassStatus status;
    private Integer free;
    @Column(name = "created_user")
    private Integer createdUser;
    @Column(name = "updated_user")
    private Integer updatedUser;
    private String uuid;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "exercise_id")
    private Long exerciseId;
}
