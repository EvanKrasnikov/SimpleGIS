package ru.geographer29.gis.util.getter;

public interface Gettable<T> {

    T get(Class<?> targetClass, String fieldName);

}
