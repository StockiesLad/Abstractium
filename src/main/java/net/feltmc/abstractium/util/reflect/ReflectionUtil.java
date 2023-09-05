package net.feltmc.abstractium.util.reflect;

import java.lang.reflect.Field;

public class ReflectionUtil {
    public static Object getValue(Object clazz, String fieldName) {
        Field field;
        try {
            field = clazz.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(true);
        Object radius;
        try {
            radius = field.get(clazz);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return radius;
    }
}
