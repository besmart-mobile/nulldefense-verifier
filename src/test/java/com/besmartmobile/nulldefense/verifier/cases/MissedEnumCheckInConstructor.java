package com.besmartmobile.nulldefense.verifier.cases;

import com.besmartmobile.nulldefense.verifier.samples.AbstractClassSample;
import com.besmartmobile.nulldefense.verifier.samples.EnumSample;
import com.besmartmobile.nulldefense.verifier.samples.InterfaceSample;
import com.besmartmobile.nulldefense.verifier.samples.SimpleClassSample;

public class MissedEnumCheckInConstructor {
    public MissedEnumCheckInConstructor(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg,
                                        SimpleClassSample simpleClassSample, AbstractClassSample abstractClassSample, InterfaceSample interfaceSample, EnumSample enumSample,
                                        int[] ints) {
        if (simpleClassSample == null) {
            throw new NullPointerException();
        }
        if (abstractClassSample == null) {
            throw new NullPointerException();
        }
        if (interfaceSample == null) {
            throw new NullPointerException();
        }
        if (ints == null) {
            throw new NullPointerException();
        }
    }
}
