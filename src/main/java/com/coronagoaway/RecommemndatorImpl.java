package com.coronagoaway;

public class RecommemndatorImpl implements Recommendator {
    @InjectedValue
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("to protect from covid-19 to drink "+alcohol);
    }
}
