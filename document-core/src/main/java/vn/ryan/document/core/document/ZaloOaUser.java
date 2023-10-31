package vn.ryan.document.core.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "zalo_oa_user")
public class ZaloOaUser extends BaseDocument {
    private String userName;
    private Long userId;
    /**
     * zaloId is user_id of zalo
     */
    private String zaloId;
    private String appId;
    private String zaloName;
    private String zaloPhone;
}
