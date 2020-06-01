package com.coronagoaway;

public class AngryPoliceman implements Policeman {
    @InjectByType
    private Recommendator recommendator;
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(recommendator.getClass());;
        System.out.println("Все вон, буду стрелять..где мой пистолет, вы у меня получите!");
    }
}
