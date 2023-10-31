package vn.ryan.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(
            String code,
            String message,
            Integer status
    ) {
        setCode(code);
        setMessage(message);
        setStatus(status);
    }

    public ForbiddenException() {}
}
