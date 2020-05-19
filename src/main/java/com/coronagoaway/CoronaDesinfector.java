package com.coronagoaway;

public class CoronaDesinfector {

    private Announcer announcer = new AnnouncerMessage();

    public void Start(Room room){
//        todo сообщить всем присутствующим в комнате, что о начале дезинфекции, и попросить всех свалить
        announcer.announce("Начинаем дезинфекцию, все вон!");
//        todo разогнать всех кто не вышел после объявления
        policeman.makePeopleLeaveRoom(room);
        desinfect(room);
//        todo сообщить всем присутствующим в комнате, что они могут вернуться обратно
        announcer.announce("Рискните зайти обратно");
    }

    private void desinfect(Room room) {
        System.out.println("зачитывается молитва: 'корона изыди!' - молитва прочитана, вирус низвергнут в ад");
    }
}
