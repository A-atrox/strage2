package smt.annotation;

import java.lang.annotation.*;

/**
 * @author guoyf
 * @Date 2020/8/12
 * @describe
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface demoAnn {
    public SexEnum sex() default SexEnum.MAN;
    public int age() default 22;
}
