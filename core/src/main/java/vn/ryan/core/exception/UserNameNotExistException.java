package vn.ryan.core.exception;

import lombok.Data;

@Data
public class UserNameNotExistException extends RuntimeException {
    public UserNameNotExistException(
            String code,
            String message,
            Integer status
    ) {
        setCode(code);
        setMessage(message);
        setStatus(status);
    }

    public UserNameNotExistException() {}
}
