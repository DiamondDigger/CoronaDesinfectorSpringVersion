package com.coronagoaway;

import lombok.SneakyThrows;

public class ObjectFactory {
    // Singleton
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig("com.coronagoaway");

    public static ObjectFactory getInstance(){ return ourInstance; }
    
    private ObjectFactory(){};
    
    // our code
    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> impClass = type;
        if (type.isInterface()) {
            impClass = config.getInstance(type);
        }
        return impClass.getDeclaredConstructor().newInstance();
    }
}

