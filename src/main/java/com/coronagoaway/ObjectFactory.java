package com.coronagoaway;
//singleton

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private static ObjectFactory getInstance(){ return ourInstance; }
}

