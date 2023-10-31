package vn.ryan.core.constants;

public enum NotificationTopic {
    ALL_TOPIC("all-topic"),
    ALL_USER_TOPIC("all-user-topic"),
    TRIAL_TOPIC("trial-topic"),
    /**
     * topic is values concat with grade and level. Ex: grade-level-topic-3-2
     */
    GRADE_LEVEL_TOPIC("grade-level-topic"),
    NOT_TEST_TOPIC("not-test-topic");

    private final String values;

    NotificationTopic(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
