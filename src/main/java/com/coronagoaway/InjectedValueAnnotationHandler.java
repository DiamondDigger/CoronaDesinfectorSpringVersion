package com.coronagoaway;

import java.lang.annotation.Annotation;

public class InjectedValueAnnotationHandler implements InjectedValue {
    @Override
    public Class<? extends Annotation> annotationType() {

        return null;
    }

    public static void main(String[] args) {
        InjectedValueAnnotationHandler annotationHandler = new InjectedValueAnnotationHandler();
        annotationHandler.annotationType();
    }
}
