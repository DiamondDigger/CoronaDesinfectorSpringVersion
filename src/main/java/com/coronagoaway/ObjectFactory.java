package com.coronagoaway;

import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ObjectFactory {

    private final ApplicationContext context;
    private Config config;
    private List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    // our code
    @SneakyThrows
    public <T> T createObject(Class<T> impClass) {

        T t = create(impClass);

        confiqure(t);

        invokeInit(impClass, t);

        return t;
    }

    private <T> void confiqure(T t) {
        for (ObjectConfigurator configurator : configurators) {
            configurator.configure(t, context);
        }
    }

    private <T> T create(Class<T> impClass) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return impClass.getDeclaredConstructor().newInstance();
    }

    private <T> void invokeInit(Class<T> impClass, T t) throws IllegalAccessException, InvocationTargetException {
        for (Method method : impClass.getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }
}

