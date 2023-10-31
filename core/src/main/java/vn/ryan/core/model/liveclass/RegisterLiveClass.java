package vn.ryan.core.model.liveclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterLiveClass implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String phone;
    private Long gradeId;
    private String liveClassName;
    private String liveClassUuid;
    private String isHaveAccount;
}
