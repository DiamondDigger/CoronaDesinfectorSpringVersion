package com.coronagoaway;

public class RecommemndatorImpl implements Recommendator {
    @InjectedProperty("Jim Bean")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("to protect from covid-19 drink " + alcohol);
    }
}
