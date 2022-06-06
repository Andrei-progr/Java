package com.company;
import java.io.Serial;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Test {

    Class<? extends Throwable> expected() default com.company.Test.None.class;

    class None extends Throwable {
        private static final long serialVersionUID = 1L;

        private None() {
        }
    }
}
