package ma.sqli.main.itevent;

import ma.sqli.main.itevent.model.Person;

public class Event {
    private Hotel hotel;

    /* Constructor */

    public Event(Hotel hotel) {
        this.hotel = hotel;
    }
    /* Functions */

    /*
     * register an attendee
     * and set the room for the attendee
     * return boolean
     */
    public boolean register(String offer, String... attendeeNames) {
        hotel.setAttendeesNumber(attendeeNames.length);
        for (String attendeeName : attendeeNames)
          if(!hotel.registerAPerson(new Person(attendeeName,offer)))
              return false;
        return true;
    }




}
