package com.besmartmobile.nulldefence.verifier.cases;

import com.besmartmobile.nulldefence.verifier.samples.AbstractClassSample;
import com.besmartmobile.nulldefence.verifier.samples.EnumSample;
import com.besmartmobile.nulldefence.verifier.samples.InterfaceSample;
import com.besmartmobile.nulldefence.verifier.samples.SimpleClassSample;

public class MissedSimpleClassCheckInConstructor {
    public MissedSimpleClassCheckInConstructor(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg,
                                               SimpleClassSample simpleClassSample, AbstractClassSample abstractClassSample, InterfaceSample interfaceSample, EnumSample enumSample,
                                               int[] ints) {
        if (abstractClassSample == null) {
            throw new NullPointerException();
        }
        if (interfaceSample == null) {
            throw new NullPointerException();
        }
        if (enumSample == null) {
            throw new NullPointerException();
        }
        if (ints == null) {
            throw new NullPointerException();
        }
    }
}
