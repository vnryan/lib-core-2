package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    private String username;
    private String password;
    private String deviceId;
    public UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
