package com.coronagoaway;

public class ConsoleAnnouncer implements Announcer {
    private Recommemndator recommemndator = ObjectFactory.getInstance().createObject()
    @Override
    public void announce(String message) {
        System.out.println(message);
    }
}
