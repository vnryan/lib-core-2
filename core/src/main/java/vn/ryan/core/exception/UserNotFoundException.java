package vn.ryan.core.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(
            String code,
            String message,
            Integer status
    ) {
        setCode(code);
        setMessage(message);
        setStatus(status);
    }

    public UserNotFoundException() {}
}
