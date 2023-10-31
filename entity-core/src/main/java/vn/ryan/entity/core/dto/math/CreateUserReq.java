package vn.ryan.entity.core.dto.math;

import lombok.Data;
import vn.ryan.entity.core.dto.edupia.CreateUserActiveRequest;

@Data
public class CreateUserReq extends CreateUserActiveRequest {
    private String name;
}
