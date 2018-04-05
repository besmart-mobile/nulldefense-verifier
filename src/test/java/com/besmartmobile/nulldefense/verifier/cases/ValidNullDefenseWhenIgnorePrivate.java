package com.besmartmobile.nulldefense.verifier.cases;

import com.besmartmobile.nulldefense.verifier.samples.SimpleClassSample;

public class ValidNullDefenseWhenIgnorePrivate {

    public void validPublicInstanceMethod(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
    }

    void validPackagePrivateInstanceMethod(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
    }

    protected void validProtectedInstanceMethod(SimpleClassSample simpleClassSample) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
    }

    private void validPrivateInstanceMethod(SimpleClassSample simpleClassSample) {
    }
}
