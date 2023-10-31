package vn.ryan.core.constants;

public enum FeedBackType {
    TYPE_LESSON("Feedback bai hoc"),
    TYPE_RATING_APP("Feekback reating app");

    private final String values;

    FeedBackType(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
