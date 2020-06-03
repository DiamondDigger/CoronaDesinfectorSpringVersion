package com.coronagoaway;

import javax.annotation.PostConstruct;

@Deprecated
public class AngryPoliceman implements Policeman {
    @InjectByType
    private Recommendator recommendator;

    @InjectProperty("")
    private String name;
    @InjectProperty("")
    private String status;

    @PostConstruct
    public void Init(){
        System.out.println(recommendator.getClass());
        System.out.println("Что происходит? Я init() метод, где все?");
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(
                status + "\n"+
                        name + ":");
        System.out.println("Все вон, буду стрелять..где мой пистолет, вы у меня получите!");
    }
}
