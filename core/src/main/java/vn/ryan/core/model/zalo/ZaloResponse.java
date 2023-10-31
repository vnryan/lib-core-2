package vn.ryan.core.model.zalo;

import lombok.Data;

import java.util.Map;

@Data
public class ZaloResponse {
    private int error;
    private String message;
    private Map<String, Object> data;
}
