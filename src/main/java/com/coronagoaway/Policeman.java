package com.coronagoaway;
public interface Policeman {
    @InjectProperty
    public static final String name = "John Cactus";
    @InjectProperty
    public static final String status = "National Guard Officer";

    void makePeopleLeaveRoom();
}
