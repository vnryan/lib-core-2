package vn.ryan.core.constants;

public enum RedisKeyEducaMath {
    REDIS_KEY_EDUCA_MATH_TOKEN_USERNAME("redis.key.educa.math.token.username"),
    /**
     * key save id: userInfo
     */
    REDIS_KEY_EDUCA_MATH_USER_INFO_ID("redis.key.educa.math.user.info.id"),
    REDIS_KEY_EDUCA_MATH_USER_INFO_USERNAME("redis.key.educa.math.user.info.username"),
    REDIS_KEY_EDUCA_MATH_USER_PROFILE_USERNAME("redis.key.educa.math.user.profile.username"),
    REDIS_KEY_EDUCA_MATH_USER_REPORT_WEEKLY("redis.key.educa.math.user.report.weekly"),
    REDIS_KEY_EDUCA_MATH_USER_REPORT_MONTHLY("redis.key.educa.math.user.report.monthly"),
    /**
     * key redis for units
     */
    REDIS_KEY_EDUCA_MATH_UNITS_ID("redis.key.educa.math.unit.id"),
    REDIS_KEY_EDUCA_MATH_UNITS_COURSE_ID("redis.key.educa.math.unit.course.id"),
    /**
     * key save id: courses
     */
    REDIS_KEY_EDUCA_MATH_COURSES_ID("redis.key.educa.math.course.id"),
    /**
     * key for lessons
     */
    REDIS_KEY_EDUCA_MATH_LESSONS_ID("redis.key.educa.math.lesson.id"),
    REDIS_KEY_EDUCA_MATH_LESSONS_UNIT_ID("redis.key.educa.math.lesson.unit.id"),
    /**
     * lesson id - list exercise
     */
    REDIS_KEY_EDUCA_MATH_EXERCISE_LESSON_ID("redis.key.educa.math.exercise.lesson.id"),
    REDIS_KEY_EDUCA_MATH_TOPIC_ID("redis.key.educa.math.topic.id"),
    /**
     * key redis for logs learn
     */
    REDIS_KEY_EDUCA_MATH_LOGS_LEARN_ID("redis.key.educa.math.logs.learn.id"),
    REDIS_KEY_EDUCA_MATH_ZALO_TOKEN("redis.key.educa.math.zalo.token"),
    REDIS_KEY_EDUCA_MATH_USERNAME_COURSE("redis.key.educa.math.username.course"),
    REDIS_KEY_EDUCA_MATH_COURSE_BY_USERNAME("redis.key.educa.math.course.by.username");

    private final String values;

    RedisKeyEducaMath(String values) {
        this.values = values;
    }

    public String getValues() {
        return this.values;
    }
}
