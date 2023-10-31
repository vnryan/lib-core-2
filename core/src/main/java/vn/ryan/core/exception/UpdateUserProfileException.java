package vn.ryan.core.exception;

public class UpdateUserProfileException extends RuntimeException {
    public UpdateUserProfileException(
            String code,
            String message,
            Integer status
    ) {
        setCode(code);
        setMessage(message);
        setStatus(status);
    }

    public UpdateUserProfileException() {}
}
