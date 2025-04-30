package week1.reflection_and_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.METHOD) // Target methods only
@Retention( RetentionPolicy.RUNTIME) // Retain annotation at runtime
public @interface LogExecutionTime {
    // No additional properties required for this annotation
}
