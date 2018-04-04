package com.besmartmobile.nulldefense.verifier.cases;

import com.besmartmobile.nulldefense.verifier.samples.SimpleClassSample;

public abstract class ValidNullDefenseInAbstractClass {

    public void validInstanceMethod(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
    }

    public abstract void validAbstractMethod(SimpleClassSample simpleClassSample);
}
