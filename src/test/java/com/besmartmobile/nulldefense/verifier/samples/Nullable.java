package com.besmartmobile.nulldefense.verifier.samples;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Nullable {
}
