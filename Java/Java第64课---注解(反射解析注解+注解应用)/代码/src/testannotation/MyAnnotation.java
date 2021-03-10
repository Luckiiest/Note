package testannotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD,CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {//接口  公有静态常量属性  公有抽象的方法

    public String[] value();//方法不是做事情 为了携带信息

}
