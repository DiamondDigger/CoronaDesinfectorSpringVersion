package com.coronagoaway;

//@Singleton
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("tea")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from covid-19 drink " + alcohol);
    }
}
