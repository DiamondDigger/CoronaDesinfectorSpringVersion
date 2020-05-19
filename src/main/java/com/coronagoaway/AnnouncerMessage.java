package com.coronagoaway;

public class AnnouncerMessage implements Announcer {
    @Override
    public void Announce(String message) {
        System.out.println(message);
    }
}
