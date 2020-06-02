package com.coronagoaway;

public interface ProxyConfigurator {
    public Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
