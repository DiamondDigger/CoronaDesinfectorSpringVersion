package com.coronagoaway;

public interface ProxyConfigurator {
    public <T> T getProxy(Class<T> type);
}
