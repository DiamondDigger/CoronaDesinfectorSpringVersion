package com.coronagoaway;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {
            if (implClass.getInterfaces().length == 0) {
                //via cglib - make proxy with inheritance from original object
                return Enhancer.create(implClass, new net.sf.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return invokeProxy(t, method, args);
                    }
                });
            } else {
                return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return invokeProxy(t, method, args);
                    }
                });
            }
        }
        return t;
    }

    private Object invokeProxy(Object t, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("******* Вы все уроды!! Что ж вы делаете, класс же @Deprecated");
        return method.invoke(t,args);
    }
}
