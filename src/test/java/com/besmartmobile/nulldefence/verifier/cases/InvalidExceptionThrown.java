package com.besmartmobile.nulldefence.verifier.cases;

import com.besmartmobile.nulldefence.verifier.samples.SimpleClassSample;

public class InvalidExceptionThrown {
    public InvalidExceptionThrown(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new IllegalStateException();
        }
    }
}
