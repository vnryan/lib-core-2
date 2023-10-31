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
@Document(collection= "firebase_token")
public class FireBaseToken extends BaseDocument {
    private String deviceId;
    private DeviceType deviceType;
    private Integer gradeId;
    private Integer levelId;
    private String userName;
    private Long userId;
    private String firebaseToken;

    public FireBaseToken(String deviceId, DeviceType deviceType, String firebaseToken) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.firebaseToken = firebaseToken;
    }
}
