package ma.sqli.main.itevent.model;

import java.util.Objects;

public class Person {
    private String name;
    private String offer;
    private String roomHotel;

    private Person() {
    }

    public Person(String name, String offer) {
        this.name = name;
        this.offer = offer;
        this.roomHotel = "empty";
    }

    public String getRoomHotel() {
        return roomHotel;
    }

    public String getName() {
        return name;
    }

    public String getOffer() {
        return offer;
    }

    public void assignRoom(String room) {
        this.roomHotel = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
