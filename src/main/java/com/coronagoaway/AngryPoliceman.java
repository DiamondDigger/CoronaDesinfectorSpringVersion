package com.coronagoaway;

import javax.annotation.PostConstruct;

public class AngryPoliceman implements Policeman {
    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void Init(){
        System.out.println(recommendator.getClass());
        System.out.println("Что происходит? Я init() метод, где все?");
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Все вон, буду стрелять..где мой пистолет, вы у меня получите!");
    }
}
