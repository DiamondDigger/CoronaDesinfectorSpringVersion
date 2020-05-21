package com.coronagoaway;

public class JavaConfig implements Config {
    @Override
    public <T> Class<? extends T> getInstance(Class<T> type) {
        return null;
    }
}
