package com.coronagoaway;

import org.reflections.Reflections;

public interface Config {
    <T> Class<? extends T> getInstance(Class<T> type);

    Reflections getScanner();
}
