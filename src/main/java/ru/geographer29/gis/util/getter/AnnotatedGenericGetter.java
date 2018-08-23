package ru.geographer29.gis.util.getter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnnotatedGenericGetter<T> implements Gettable<T> {
    List<T> classesWithAnnotation = new ArrayList<>();

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

    private Path getClassPath(){
        return Paths.get(System.getProperty("classpath"));
    }

    private void iterateFiles(){
        Path path = getClassPath();
        List<String> list;

        if (!Files.isDirectory(path))
            throw new RuntimeException("It is not directory!");

        try {
            list = Files.readAllLines(iter.next());

            for(String s: list){
                if (s.contains("@ScanGetters")){

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
