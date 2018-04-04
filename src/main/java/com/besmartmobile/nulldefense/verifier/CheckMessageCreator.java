package com.besmartmobile.nulldefense.verifier;

import java.lang.reflect.Parameter;

public interface CheckMessageCreator {
    String createMessage(Parameter[] parameters, int nullParameterIndex);
}
