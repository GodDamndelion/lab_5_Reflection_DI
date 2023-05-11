package lab5;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

/**
 * "Injector" class with a single method
 */
public class Injector {

    /**
     * Returns filled class
     * @param object some class
     * @return filled class object
     */
    public Object inject(Object object) {
        if (object != null) {
            Class<?> myClass = object.getClass();
            System.out.println(myClass);
            System.out.println("Поля класса: " + Arrays.toString(myClass.getDeclaredFields()));
            System.out.println("Методы класса: " + Arrays.toString(myClass.getDeclaredMethods()));
            Properties property = new Properties();
            String propertyFileName = "init.properties";
            InputStream inputStream = myClass.getClassLoader().getResourceAsStream(propertyFileName);
            try {
                property.load(inputStream);
                for (Field field : myClass.getDeclaredFields()) {
                    AutoInjectable myAnnotation = field.getAnnotation(AutoInjectable.class);
                    if (myAnnotation != null) {
                        field.setAccessible(true);
                        String className = property.getProperty(field.getName());
                        try {
                            Object value = Class.forName(className).newInstance();
                            field.set(object, value);
                        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return object;
    }
}
