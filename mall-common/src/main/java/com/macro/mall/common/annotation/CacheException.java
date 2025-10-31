package com.macro.mall.common.annotation;

import java.lang.annotation.*;

/**
 * Custom annotation. Cache methods annotated with this will throw exceptions.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
