package com.coronagoaway;

public class AnnouncerMessage implements Announcer {
    @Override
    public void announce(String message) {
        System.out.println(message);
    }
}
