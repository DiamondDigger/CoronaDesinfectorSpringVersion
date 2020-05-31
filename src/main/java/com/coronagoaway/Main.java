package com.coronagoaway;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Application application = new Application();
        ApplicationContext context = application.run("com.coronagoaway", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
        CoronaDesinfector coronaDesinfector = context.getObject(CoronaDesinfector.class);
        coronaDesinfector.start(new Room());
    }
}
