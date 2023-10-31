package vn.ryan.core.model.zalo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZaloToken implements Serializable {
    private String accessToken;
    private String refreshToken;
    private Integer expiresIn;
}
