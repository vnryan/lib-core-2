package vn.ryan.core.constants;

public enum ActionType {
    OPEN_APP_FIRST("Open app first"),
    REGISTER_TRIAL("Register trial"),
    UPDATE_GRADE_ID("Update grade id"),
    LOGIN("login"),
    CREATE_USER_ACTIVE("Create user active");

    private final String values;

    ActionType(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
