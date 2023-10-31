package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginWithTokenRequest {
    private String username;
    private String token;
    private String refreshToken;
    private Long userId;
    private String deviceId;
    public UserLoginWithTokenRequest(String username, String token, String refreshToken, Long userId) {
        this.username = username;
        this.token = token;
        this.refreshToken = refreshToken;
        this.userId = userId;
    }
}
