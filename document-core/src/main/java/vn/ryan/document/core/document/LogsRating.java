package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.ryan.core.constants.DeviceType;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "logs_rating")
public class LogsRating extends BaseDocument {
    private String username;
    private Long userInfoId;
    private DeviceType deviceType;
    private String rating;
    private String note;
}
