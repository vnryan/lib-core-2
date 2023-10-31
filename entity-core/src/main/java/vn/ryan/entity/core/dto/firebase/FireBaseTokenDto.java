package vn.ryan.entity.core.dto.firebase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.ryan.core.constants.ActionType;
import vn.ryan.core.constants.DeviceType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FireBaseTokenDto {
    private String deviceId;
    private DeviceType deviceType;
    private Integer gradeId;
    private Integer levelId;
    private String userName;
    private Long userId;
    private String firebaseToken;
    private ActionType actionType;
    public FireBaseTokenDto(String deviceId, String firebaseToken, DeviceType deviceType) {
        this.deviceId = deviceId;
        this.firebaseToken = firebaseToken;
        this.deviceType = deviceType;
        this.actionType = ActionType.OPEN_APP_FIRST;
    }
}
