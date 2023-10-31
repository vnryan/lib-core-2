package vn.ryan.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String userName;
    private Long userId;
    private String mathToken;
    private String generalToken;
    private String refreshToken;
    private Integer expire;
    private String deviceId;
    private String deviceType;
}
