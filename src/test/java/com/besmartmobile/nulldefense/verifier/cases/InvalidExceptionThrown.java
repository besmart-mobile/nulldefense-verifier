package com.besmartmobile.nulldefense.verifier.cases;

import com.besmartmobile.nulldefense.verifier.samples.SimpleClassSample;

public class InvalidExceptionThrown {
    public InvalidExceptionThrown(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new IllegalStateException();
        }
    }
}
