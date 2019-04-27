package ma.sqli.main.itevent;

import ma.sqli.main.itevent.constants.Contants;
import ma.sqli.main.itevent.model.Person;
import ma.sqli.main.itevent.rooms.AppartRoom;
import ma.sqli.main.itevent.rooms.Room;
import ma.sqli.main.itevent.rooms.StandardRoom;
import ma.sqli.main.itevent.rooms.SuitRoom;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Hotel {
    private Room standardRooms, suites, apparts;

    private Set<Person> persons = new HashSet<>();

    //To know if we should give to the attendees the same room or not
    private boolean sameRoom;

    //To know how many attendees registred at the same time
    private int attendeesNumber;

    /* Constructors */
    private Hotel() {
        attendeesNumber = 0;
        sameRoom = false;
    }

    public Hotel(int standardRooms, int suites, int apparts) {
        this();
        this.standardRooms = new StandardRoom(standardRooms);
        this.suites = new SuitRoom(suites);
        this.apparts = new AppartRoom(apparts);
    }

    /* Functions */
    /*
     * check Contants available
     *
     * return String
     */
    public String checkAvailibility() {
        return "Standard rooms: " + this.standardRooms.getRoomNumber()
                + "|Suites: " + this.suites.getRoomNumber()
                + "|Aparts: " + this.apparts.getRoomNumber();
    }

    /*
     * grant an attendee a room based on his offer
     *
     * return String
     */
    public String getRoomFor(String name) {
        Optional<Person> person = persons.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst();
        return person.isPresent() ? person.get().getRoomHotel() : "No room found for " +name;
    }

    public boolean registerAPerson(Person person) {
        if (persons.add(person))
            return reserveRoom(person);
        return false;
    }

    public void setAttendeesNumber(int attendeesNumber) {
        this.attendeesNumber = attendeesNumber;
    }

    private boolean checkIfTheresStandardRoomAvailable() {
        return standardRooms.CheckIfTheresRoomAvailable(attendeesNumber);
    }

    private void bookAStandardRoomTo(Person person) {
        person.assignRoom(standardRooms.roomBooked());
        sameRoom = false;
    }

    private void bookAnAppartTo(Person person) {
        person.assignRoom(apparts.roomBooked());
        sameRoom = false;
    }

    private void bookASuitTo(Person person) {
        person.assignRoom(suites.roomBooked());
        sameRoom = false;
    }

    private void bookSameStandardRoomTo(Person person) {
        person.assignRoom(standardRooms.sameroomBooked(sameRoom));
        sameRoom = true;
    }

    private boolean reserveRoom(Person person) {
        switch (person.getOffer()) {
            case Contants.TRINGA:
            case Contants.STAFF:
                if (checkIfTheresStandardRoomAvailable()) bookAStandardRoomTo(person);
                else bookAnAppartTo(person);
                break;
            case Contants.SPEAKER:
                bookASuitTo(person);
                break;
            case Contants.CONF:
            case Contants.DEEP_DIVE:
                bookSameStandardRoomTo(person);
                break;
        }
        return true;
    }

}
