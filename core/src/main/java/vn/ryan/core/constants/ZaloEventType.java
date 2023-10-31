package vn.ryan.core.constants;

public enum ZaloEventType {
    FOLLOW("follow"),
    UNFOLLOW("unfollow"),
    USER_SEND_TEXT("user_send_text");

    private final String values;

    ZaloEventType(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
