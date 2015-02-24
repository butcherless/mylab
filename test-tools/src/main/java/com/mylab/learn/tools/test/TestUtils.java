package com.mylab.learn.tools.test;

import java.io.Serializable;
import java.lang.reflect.Constructor;

import org.junit.Assert;

public class TestUtils {
    private static final String MESSAGE = "message";
    private static final RuntimeException RE = new RuntimeException();

    @SuppressWarnings("rawtypes")
    public static Boolean checkSerializable(final Class clazz) {
        return Serializable.class.isAssignableFrom(clazz);
    }

    public static void testException(Class<? extends RuntimeException> clazz) throws Exception {
        clazz.newInstance();
        Constructor<? extends RuntimeException> cons = clazz
                .getConstructor(new Class[] { String.class });
        cons.newInstance(MESSAGE);
        cons = clazz.getConstructor(new Class[] { Throwable.class });
        cons.newInstance(RE);
        cons = clazz.getConstructor(new Class[] { String.class, Throwable.class });
        RuntimeException exception = (RuntimeException) cons.newInstance(MESSAGE, RE);

        Assert.assertEquals(MESSAGE, exception.getMessage());
        Assert.assertEquals(RE, exception.getCause());
    }
}
