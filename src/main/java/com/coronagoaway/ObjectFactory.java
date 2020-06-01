package com.coronagoaway;

import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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

        //часть конструктора - второй конструктор, вызываемый после того
        // как отработает конструктор и просетятся поля, поэтому оставляем метод @PostConstruct в фабрике
        invokeInit(impClass, t);

        if (impClass.isAnnotationPresent(Deprecated.class)) {
            Proxy.newProxyInstance(impClass.getClassLoader(), impClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (impClass.getInterfaces().length != 0) {
                        System.out.println("******* Вы все уроды!! Что ж вы делаете, класс же @Deprecated");
                        invoke(t, method,args);
                    }
                    return t;
                }
            });
        }


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

