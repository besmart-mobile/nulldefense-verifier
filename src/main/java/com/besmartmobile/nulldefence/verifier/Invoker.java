package com.besmartmobile.nulldefence.verifier;

import java.lang.reflect.InvocationTargetException;

public interface Invoker {
    void invoke(Object[] parameterValues) throws InvocationTargetException, IllegalAccessException, InstantiationException;
}
