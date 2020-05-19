package com.coronagoaway;

public class CoronaDesinfector {

    public void Start(Room room){
//        todo сообщить всем присутствующим в комнате, что о начале дезинфекции, и попросить всех свалить
//        todo разогнать всех кто не вышел после объявления
        desinfect(room);
//        todo сообщить всем присутствующим в комнате, что они могут вернуться обратно
    }

    private void desinfect(Room room) {
        System.out.println("зачитывается молитва: 'корона изыди!' - молитва прочитана, вирус низвергнут в ад");
    }
}
