package myselfannotation;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    public abstract String[] value();//默认方法---->属性

}
