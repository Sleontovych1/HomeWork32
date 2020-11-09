package ua.home.javapro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        TextContainer container = new TextContainer();
        Class<?> cls = container.getClass();

        SaveToFile clsAnnotation = cls.getAnnotation(SaveToFile.class);

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(container, clsAnnotation.pathToFile());
            }
        }
    }
}
