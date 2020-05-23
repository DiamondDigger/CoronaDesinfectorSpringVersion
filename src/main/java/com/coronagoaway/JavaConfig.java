package com.coronagoaway;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageScan, Map<Class,Class> ifc2ImplClass) {
        this.scanner = new Reflections(packageScan);
        this.ifc2ImplClass = ifc2ImplClass;
    }

    @Override
    public <T> Class<? extends T> getInstance(Class<T> ifc) {
       return ifc2ImplClass.computeIfAbsent(ifc,aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() > 3) {
                throw new RuntimeException(ifc + ": has 0 or more than one implementation");
            }
            return classes.iterator().next();
        });
    }
}
