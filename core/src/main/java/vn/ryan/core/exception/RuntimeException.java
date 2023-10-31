package vn.ryan.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RuntimeException extends java.lang.RuntimeException {
    private String code;
    private String message;
    private Integer status;
}
