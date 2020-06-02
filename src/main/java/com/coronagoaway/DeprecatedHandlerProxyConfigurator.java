package com.coronagoaway;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> T getProxy(Class<T> impClass) {
        if (impClass.isAnnotationPresent(Deprecated.class)) {
            if (impClass.getInterfaces().length == 0) {
                //via cglib - make proxy with inheritance from original object
                Enhancer.create(impClass, new net.sf.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return invokeProxy(method, args);
                    }
                })
            } else {
                return (T) Proxy.newProxyInstance(impClass.getClassLoader(), impClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return invokeProxy(method, args);
                    }
                });
            }
        }
    }

    private Object invokeProxy(Method method, Object[] args) {
        System.out.println("******* Вы все уроды!! Что ж вы делаете, класс же @Deprecated");
        return method.invoke(t,args);
    }
}
