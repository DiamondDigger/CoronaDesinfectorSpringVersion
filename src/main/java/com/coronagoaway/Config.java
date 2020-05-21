package com.coronagoaway;

public interface Config {
    <T> Class<? extends T> getInstance(Class<T> type);
}
