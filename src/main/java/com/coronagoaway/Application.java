package com.coronagoaway;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageScan, Map<Class, Class> ifc2ImplClass){
        JavaConfig config = new JavaConfig(packageScan,ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);

        context.setFactory(objectFactory);

        return context;
    }
}
