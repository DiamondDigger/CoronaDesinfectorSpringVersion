package com.coronagoaway;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ObjectFactory {

    private Config config;

    // Singleton
    private static ObjectFactory ourInstance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        config = new JavaConfig("com.coronagoaway", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
    }

    // our code
    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> impClass = type;
        if (type.isInterface()) {
            impClass = config.getInstance(type);
        }
        T t = impClass.getDeclaredConstructor().newInstance();

        Field[] fields = impClass.getDeclaredFields();
        for (Field field : fields) {
            InjectedProperty annotation = field.getAnnotation(InjectedProperty.class);
            if (annotation!=null) {
                if (annotation.value().isEmpty()) {
                    String path = ClassLoader.getSystemClassLoader().getResource("recommendation.properties").getPath();
                    Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
                }
            }
        }


        return t;
    }
}

