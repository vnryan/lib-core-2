package vn.ryan.core.constants;

public enum LevelType {
    TYPE_QUESTION("Level of course"),
    LEVEL_COURSE("Level of question");

    private final String values;

    LevelType(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
