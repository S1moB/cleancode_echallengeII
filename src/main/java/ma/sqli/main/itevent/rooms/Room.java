package ma.sqli.main.itevent.rooms;

public interface Room {
    String roomBooked();
    String sameroomBooked(Boolean sameRoom);
    Boolean CheckIfTheresRoomAvailable(int attendee);
    int getRoomNumber();
}
