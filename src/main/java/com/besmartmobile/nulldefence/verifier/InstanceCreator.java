package com.besmartmobile.nulldefence.verifier;

import javassist.util.proxy.ProxyFactory;
import org.objenesis.Objenesis;
import org.objenesis.instantiator.ObjectInstantiator;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;

class InstanceCreator {

    private final Objenesis objenesis;

    InstanceCreator(Objenesis objenesis) {
        this.objenesis = objenesis;
    }

    Object getNonNullValue(Class<?> type) {
        if (type.isPrimitive()) {
            return DefaultPrimitiveValues.getDefaultPrimitiveValue(type);
        } else {
            return generateInstanceForNonPrimitiveType(type);
        }
    }

    private Object generateInstanceForNonPrimitiveType(Class<?> type) {
        if (type.isArray()) {
            return Array.newInstance(type.getComponentType(), 0);
        } else if (type.isInterface()) {
            return generateInterfaceInstance(type);
        } else if (type.isEnum()) {
            return generateEnumInstance(type);
        } else if (Modifier.isAbstract(type.getModifiers())) {
            return generateAbstractClassInstance(type);
        } else {
            return generateSimpleClassInstance(type);
        }
    }

    private Object generateAbstractClassInstance(Class<?> type) {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(type);
        factory.setHandler((arg0, method, arg2, arg3) -> {
            throw new NoSuchMethodException();
        });
        Class parameterAbstractClassImplementation = factory.createClass();
        try {
            return parameterAbstractClassImplementation.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    private Object generateSimpleClassInstance(Class<?> type) {
        ObjectInstantiator objectInstantiator = objenesis.getInstantiatorOf(type);
        return objectInstantiator.newInstance();
    }

    private Object generateEnumInstance(Class<?> type) {
        return type.getEnumConstants()[0];
    }

    private Object generateInterfaceInstance(Class<?> type) {
        Object interfaceParameterInstance = java.lang.reflect.Proxy.newProxyInstance(
                type.getClassLoader(),
                new Class[] {type},
                (proxy, method, args) -> {
                    throw new NoSuchMethodException();
                }
        );
        return interfaceParameterInstance;
    }
}
