package vn.ryan.core.constants;

public enum FeedBackLessonType {
    VIDEO_QUALITY("Hinh anh video chua ro net"),
    VIDEO_AUDIO("Am thanh nghe khong ro"),
    TEACHER_FAST("Giao vien giang hoi nhanh"),
    TEACHER_SLOW("Giao vien giang hoi cham"),
    LESSON_NOT_INTERESTING("Feedback bai hoc khong hap dan"),
    APP_DIFFICULT_TO_USE("Feedback game khong hap dan"),
    GAME_NOT_INTERESTING("Feedback app kho dung"),
    OTHER("Feedback y kien khac");

    private final String values;

    FeedBackLessonType(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
