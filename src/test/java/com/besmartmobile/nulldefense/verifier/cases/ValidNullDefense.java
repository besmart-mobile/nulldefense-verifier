package com.besmartmobile.nulldefense.verifier.cases;

import com.besmartmobile.nulldefense.verifier.samples.AbstractClassSample;
import com.besmartmobile.nulldefense.verifier.samples.EnumSample;
import com.besmartmobile.nulldefense.verifier.samples.InterfaceSample;
import com.besmartmobile.nulldefense.verifier.samples.SimpleClassSample;

public class ValidNullDefense {
    public ValidNullDefense() {
    }

    public ValidNullDefense(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg) {
    }

    public static void validStaticMethod(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg) {
    }

    public void validInstanceMethod(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg) {
    }

    public ValidNullDefense(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg,
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
        if (enumSample == null) {
            throw new NullPointerException();
        }
        if (ints == null) {
            throw new NullPointerException();
        }
    }

    public static void validStaticMethod(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg,
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
        if (enumSample == null) {
            throw new NullPointerException();
        }
        if (ints == null) {
            throw new NullPointerException();
        }
    }

    public void validInstanceMethod(boolean booleanArg, byte byteArg, short shortArg, char charArg, int intArg, long longArg, float floatArg, double doubleArg,
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
        if (enumSample == null) {
            throw new NullPointerException();
        }
        if (ints == null) {
            throw new NullPointerException();
        }
    }

    public void methodWithLambdaInIt() {
        doSmthWithTestInterface(o -> {});
    }

    public void doSmthWithTestInterface(TestInterface testInterface) {
        if (testInterface == null) {
            throw new NullPointerException();
        }
    }

    interface TestInterface {
        void test(Object o);
    }
}
