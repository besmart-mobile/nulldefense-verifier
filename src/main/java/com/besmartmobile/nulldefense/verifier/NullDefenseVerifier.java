package com.besmartmobile.nulldefense.verifier;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

public class NullDefenseVerifier {

    private final Class<?> clazz;
    private final InstanceCreator instanceCreator;

    private NullDefenseVerifier(Class<?> clazz) {
        this.clazz = clazz;
        Objenesis objenesis = new ObjenesisStd();
        this.instanceCreator = new InstanceCreator(objenesis);
    }

    public static NullDefenseVerifier forClass(Class<?> clazz) {
        if (clazz == null) {
            throw new NullPointerException();
        }
        return new NullDefenseVerifier(clazz);
    }

    /**
     * Performs the verification of the Null Defense contract
     *
     * @throws NullDefenseNotImplementedProperlyError If the contract is not met
     */
    public void verify() {
        verifyConstructors();
        verifyMethods();
    }

    private void verifyConstructors() {
        for (Constructor c : clazz.getDeclaredConstructors()) {
            verifyConstructor(c);
        }
    }

    private void verifyMethods() {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!isMethodVerificationNeeded(method)) {
                continue;
            }
            verifyMethod(method);
        }
    }

    private boolean isMethodVerificationNeeded(Method method) {
        return !method.isSynthetic() && !Modifier.isAbstract(method.getModifiers());
    }

    private void verifyMethod(Method method) {
        if (Modifier.isStatic(method.getModifiers())) {
            verifyStaticMethod(method);
        } else {
            verifyInstanceMethod(method);
        }
    }

    private void verifyStaticMethod(Method method) {
        verifyInvokable(method.getParameters(),
                (parameters, nullParameterIndex) -> getMethodVerificationDetails(method, parameters, nullParameterIndex),
                parameterValues -> {
                    method.setAccessible(true);
                    method.invoke(null, parameterValues);
                }
        );
    }

    private void verifyInstanceMethod(Method method) {
        verifyInvokable(method.getParameters(),
                (parameters, nullParameterIndex) -> getMethodVerificationDetails(method, parameters, nullParameterIndex),
                parameterValues -> {
                    Object clazzInstance = instanceCreator.getNonNullValue(clazz);
                    method.setAccessible(true);
                    method.invoke(clazzInstance, parameterValues);
                }
        );
    }

    private void verifyConstructor(Constructor constructor) {
        verifyInvokable(constructor.getParameters(),
                (parameters, nullParameterIndex) -> getConstructorVerificationDetails(parameters, nullParameterIndex),
                parameterValues -> {
                    constructor.setAccessible(true);
                    constructor.newInstance(parameterValues);
                }
        );
    }

    private void verifyInvokable(Parameter[] parameters, CheckMessageCreator checkMessageCreator, Invoker invoker) {
        for (int i = 0; i < parameters.length; i++) {
            Class<?> testParameterType = parameters[i].getType();
            if (!isNullCheckNeeded(testParameterType)) {
                continue;
            }
            Object[] parameterValues = generateParameterValues(parameters, i);
            String checkDetails = checkMessageCreator.createMessage(parameters, i);
            verifyInvocationThrowsCorrectException(invoker, parameterValues,
                    checkDetails);
        }
    }

    private void verifyInvocationThrowsCorrectException(Invoker invoker, Object[] parameterValues, String checkDetails) {
        try {
            invoker.invoke(parameterValues);
            failCheck(checkDetails);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof NullPointerException)) {
                failCheck(checkDetails);
            }
        } catch (IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private Object[] generateParameterValues(Parameter[] parameters, int nullParameterIndex) {
        ArrayList<Object> parameterValues = new ArrayList<>();
        for (int j = 0; j < parameters.length; j++) {
            if (j == nullParameterIndex) {
                parameterValues.add(null);
            } else {
                Object parameterInstance = instanceCreator.getNonNullValue(parameters[j].getType());
                parameterValues.add(parameterInstance);
            }
        }
        return parameterValues.toArray();
    }

    private boolean isNullCheckNeeded(Class<?> parameterType) {
        return !parameterType.isPrimitive();
    }

    private String getMethodVerificationDetails(Method method, Parameter[] parameters, int nullParameterIndex) {
        return "Failed check:\n" +
                "Method " + method.getName() + " with " + parameters.length + " parameters:\n" +
                Arrays.toString(parameters) + "\n" +
                "with parameter " + parameters[nullParameterIndex] + " as null";
    }

    private String getConstructorVerificationDetails(Parameter[] parameters, int nullParameterIndex) {
        return "Failed check:\n" +
                "Constructor with " +
                parameters.length + " parameters:\n" +
                Arrays.toString(parameters) + "\n" +
                "with parameter " + parameters[nullParameterIndex] + " as null";
    }

    private static void failCheck(String checkDetails) {
        throw new NullDefenseNotImplementedProperlyError(checkDetails);
    }
}
