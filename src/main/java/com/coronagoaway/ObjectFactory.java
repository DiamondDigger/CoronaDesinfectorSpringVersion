package com.coronagoaway;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {

    private Config config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    // Singleton

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {

//        config = new JavaConfig("com.coronagoaway", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    // our code
    @SneakyThrows
    public <T> T createObject(Class<T> impClass) {

        T t = impClass.getDeclaredConstructor().newInstance();
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t);
        }
        return t;
    }
}

