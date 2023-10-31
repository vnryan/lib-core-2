package vn.ryan.entity.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.ryan.core.constants.LiveClassStatus;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiveClassDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Long id;
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
    private String seedingTime;
    /**
     * link other app
     */
    private String link;
    private String videoTime;
    private String teacher;
    private String image;
    private LiveClassStatus status;
    private Integer free;
    private Integer createdUser;
    private Integer updatedUser;
    private String uuid;
    private Integer isActive;
    private Long exerciseId;
    private Object exerciseDetail;
    private Timestamp startTime;
    private Date createdAt;
    private Date updatedAt;
}
