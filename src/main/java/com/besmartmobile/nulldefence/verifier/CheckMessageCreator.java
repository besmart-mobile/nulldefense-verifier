package com.besmartmobile.nulldefence.verifier;

import java.lang.reflect.Parameter;

public interface CheckMessageCreator {
    String createMessage(Parameter[] parameters, int nullParameterIndex);
}
