package com.coronagoaway;

import java.lang.annotation.Annotation;

public class InjectedValueAnnotationHandler implements InjectedValue {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
