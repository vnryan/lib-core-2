package vn.ryan.core.constants;

public enum PartType {
    GAME("Game Play"),
    VIDEO("Video"),
    EXERCISE("Bài luyện tập"),
    HOME_WORK("Bài tập về nhà"),
    HOMEWORK("Bài tập về nhà"),
    LIVE_CLASS("Live class"),
    MATH_LIVE_CLASS("Live class core"),
    TEST("Bài kiểm tra");

    private final String values;

    PartType(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
