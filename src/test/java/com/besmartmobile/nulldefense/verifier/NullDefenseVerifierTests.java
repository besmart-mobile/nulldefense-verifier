package com.besmartmobile.nulldefense.verifier;

import com.besmartmobile.nulldefense.verifier.cases.*;
import org.junit.Test;

public class NullDefenseVerifierTests {

    @Test
    public void ValidNullDefense_passes_verification() throws Exception {
        NullDefenseVerifier.forClass(ValidNullDefense.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void MissedSimpleClassCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedSimpleClassCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void MissedInterfaceCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedInterfaceCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void MissedEnumCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedEnumCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void MissedArrayCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedArrayCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void MissedAbstractClassCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedAbstractClassCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void InvalidExceptionThrown_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(InvalidExceptionThrown.class).verify();
    }

    @Test(expected = NullDefenseNotImplementedProperlyError.class)
    public void ValidNullDefenseInAbstractClass_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(ValidNullDefenseInAbstractClass.class).verify();
    }
}
