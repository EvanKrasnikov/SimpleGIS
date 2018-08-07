package ru.geographer29.gis.util.getter;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenericGetter<T> implements Gettable<T>{
    private static final Logger logger = LogManager.getLogger();

    @SuppressWarnings("unchecked")
    public T get(Class<?> targetClass, String fieldName) {
        T obj = null;

        try {
            Field field = targetClass.getClass().getDeclaredField(fieldName);
            obj = (T)field.get(targetClass);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            logger.fatal("Getter is not working!");
        }

        return obj;
    }

}
