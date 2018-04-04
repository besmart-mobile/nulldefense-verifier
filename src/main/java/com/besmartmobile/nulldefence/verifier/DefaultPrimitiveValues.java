package com.besmartmobile.nulldefence.verifier;

class DefaultPrimitiveValues {

    static Object getDefaultPrimitiveValue(Class<?> type) {
        if (type == null) {
            throw new NullPointerException();
        }
        if (type == boolean.class) {
            return false;
        } else if (type == int.class) {
            return 0;
        } else if (type == long.class) {
            return 0L;
        } else if (type == char.class) {
            return (char) 0;
        } else if (type == short.class) {
            return (short) 0;
        } else if (type == byte.class) {
            return (byte) 0;
        } else if (type == float.class) {
            return 0F;
        } else if (type == double.class) {
            return 0D;
        } else {
            throw new IllegalStateException();
        }
    }
}
