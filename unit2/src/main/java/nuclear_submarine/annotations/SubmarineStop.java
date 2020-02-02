package nuclear_submarine.annotations;

import java.lang.annotation.*;

@Documented
@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface SubmarineStop {
}
