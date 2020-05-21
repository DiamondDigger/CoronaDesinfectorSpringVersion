package com.coronagoaway;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {

    private Reflections scanner;

    public JavaConfig(String packageScan) {
        this.scanner = new Reflections(packageScan);
    }

    @Override
    public <T> Class<? extends T> getInstance(Class<T> ifc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() >3) {
                throw new RuntimeException(ifc+ ": has 0 or more than one implementation");
            }
        return classes.iterator().next();
    }
}
