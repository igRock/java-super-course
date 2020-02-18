package nuclear_submarine.annotations;

import java.lang.annotation.*;

@Documented
@Target(value= ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Submarine {
    String name();
}
