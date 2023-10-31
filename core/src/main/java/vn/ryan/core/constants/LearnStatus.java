package vn.ryan.core.constants;

public enum LearnStatus {
    PROCESSING("Đang thực hiện"),
    DONE("Hoàn thành"),
    OPEN("Chưa làm");

    private final String values;

    LearnStatus(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
