package jit.txy.newbeemall.config.annotation;

import java.lang.annotation.*;

/**
 * @author 唐星宇
 * @date 2022/9/15
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToAdminUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default "adminUser";

}

