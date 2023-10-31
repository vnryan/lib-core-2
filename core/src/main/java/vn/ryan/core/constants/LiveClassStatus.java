package vn.ryan.core.constants;

public enum LiveClassStatus {
    CANCELED("Đã hủy"),
    OPEN("Chưa mở"),
    PRE_LIVE("Sắp diễn ra"),
    IN_PROGRESS("Đang diễn ra"),
    CLOSED("Đã diễn ra");
    private final String values;

    LiveClassStatus(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
