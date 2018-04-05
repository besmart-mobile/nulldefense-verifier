package com.besmartmobile.nulldefense.verifier.cases;

import com.besmartmobile.nulldefense.verifier.samples.Nullable;
import com.besmartmobile.nulldefense.verifier.samples.SimpleClassSample;

public class ValidNullDefenseWithNullableAttribute {

    public void validInstanceMethod(@Nullable SimpleClassSample nullableSimpleClassSample,
                                    SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
    }
}
