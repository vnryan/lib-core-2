package vn.edupiamath.queue.core.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;
import vn.edupiamath.queue.core.config.*;

@Import(value = {
        QueueConfiguration.class,
        FireBaseTokenQueueConfig.class,
        FeedbackQueueConfig.class,
        LogsLearnQueueConfig.class,
        CourseQueueConfig.class,
        UnitQueueConfig.class,
        LessonQueueConfig.class
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableQueueCore {

}
