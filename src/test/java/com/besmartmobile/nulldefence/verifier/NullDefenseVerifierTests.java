package com.besmartmobile.nulldefence.verifier;

import com.besmartmobile.nulldefence.verifier.cases.*;
import org.junit.Test;

public class NullDefenseVerifierTests {

    @Test
    public void ValidNullDefence_passes_verification() throws Exception {
        NullDefenseVerifier.forClass(ValidNullDefense.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void MissedSimpleClassCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedSimpleClassCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void MissedInterfaceCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedInterfaceCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void MissedEnumCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedEnumCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void MissedArrayCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedArrayCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void MissedAbstractClassCheckInConstructor_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(MissedAbstractClassCheckInConstructor.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void InvalidExceptionThrown_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(InvalidExceptionThrown.class).verify();
    }

    @Test(expected = NullDefenceNotImplementedProperlyError.class)
    public void ValidNullDefenseInAbstractClass_doesnt_pass_verification() throws Exception {
        NullDefenseVerifier.forClass(ValidNullDefenseInAbstractClass.class).verify();
    }
}
