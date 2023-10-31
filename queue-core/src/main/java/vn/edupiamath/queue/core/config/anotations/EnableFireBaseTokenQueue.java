package vn.edupiamath.queue.core.config.anotations;

import org.springframework.context.annotation.Import;
import vn.edupiamath.queue.core.config.FireBaseTokenQueueConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Import(value = {
        FireBaseTokenQueueConfig.class
})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableFireBaseTokenQueue {

}
