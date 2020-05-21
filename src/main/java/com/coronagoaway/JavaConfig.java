package com.coronagoaway;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {

    private Reflections scanner;

    public JavaConfig(String path) {
        this.scanner = scanner;
    }

    @Override
    public <T> Class<? extends T> getInstance(Class<T> type) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
        if (type.isInterface()) {

        }
    }
}
