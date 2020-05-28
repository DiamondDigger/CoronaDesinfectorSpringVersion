package com.coronagoaway;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

public class InjectByPropertyAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    public void confogure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                AnnotatedType type = field.getAnnotatedType();
                ObjectFactory.getInstance().createObject()
            }
        }
    }
}
