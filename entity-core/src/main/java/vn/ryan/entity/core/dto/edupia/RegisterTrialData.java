package vn.ryan.entity.core.dto.edupia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTrialData {
    private String phone;
    private String customerName;
    private String campaignName;
    private String sourceCollect;
    private Long timeRegister;
    private String note;
    private String packageId;
    private String numberDay;
    private String pointAvg;
    private String product;
}
