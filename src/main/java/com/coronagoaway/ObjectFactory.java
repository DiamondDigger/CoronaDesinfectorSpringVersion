package com.coronagoaway;

public class ObjectFactory {
    // Singleton
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance(){ return ourInstance; }
    
    private ObjectFactory(){};
    
    // our code 
    public <T> T createObject(Class<T> type){
        Class<? extends T> classImpl = config.getInstance(type);
        return null;
    }
}

