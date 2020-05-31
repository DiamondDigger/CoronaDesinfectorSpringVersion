package com.coronagoaway;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    private ApplicationContext context;
    private Config config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
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
            configurator.configure(t, context);
        }
        return t;
    }
}

