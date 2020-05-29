package com.coronagoaway;

import java.util.Map;
import java.util.Set;

public class Application {
    public void run(String packageScan, Map<Class, Class> ifc2ImplClass){
        JavaConfig config = new JavaConfig(packageScan,ifc2ImplClass);
        Set<Class<? extends ObjectConfigurator>> subTypesOf = config.getScanner().getSubTypesOf(ObjectConfigurator.class);

    }
}
