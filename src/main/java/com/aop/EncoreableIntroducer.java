package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by 高保红 on 2017/8/2.
 */
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "com.aop.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
