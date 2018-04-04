package com.besmartmobile.nulldefence.verifier.cases;

import com.besmartmobile.nulldefence.verifier.samples.AbstractClassSample;
import com.besmartmobile.nulldefence.verifier.samples.EnumSample;
import com.besmartmobile.nulldefence.verifier.samples.InterfaceSample;
import com.besmartmobile.nulldefence.verifier.samples.SimpleClassSample;

public abstract class ValidNullDefenseInAbstractClass {

    public void validInstanceMethod(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
    }

    public abstract void validAbstractMethod(SimpleClassSample simpleClassSample);
}
