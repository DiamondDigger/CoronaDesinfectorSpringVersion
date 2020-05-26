package com.coronagoaway;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
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
            if (annotation != null) {
                String path = ClassLoader.getSystemClassLoader().getResource("recommendation.properties").getPath();
                Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
                Map<String, String> mapOfValues = lines.map(x -> x.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
                String value = annotation.value().isEmpty() ? mapOfValues.get(field.getName()) : mapOfValues.get(annotation.value());
                field.setAccessible(true);
                field.set(t, value);
            }
        }
        return t;
    }
}

