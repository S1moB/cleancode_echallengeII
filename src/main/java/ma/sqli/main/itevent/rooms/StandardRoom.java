package ma.sqli.main.itevent.rooms;

import static ma.sqli.main.itevent.constants.Contants.STANDARD_START_NUMBER;

public class StandardRoom implements Room {

    private int standardRooms;
    private int standardRoomNumber;

    private final String STANDARD_ROOM = "Standard room N°";
    private StandardRoom(){}
    public StandardRoom(int standardRooms)
    {
        standardRoomNumber = STANDARD_START_NUMBER;
        this.standardRooms = standardRooms;
    }
    @Override
    public String roomBooked() {
        standardRooms -= 1;
        return STANDARD_ROOM + standardRoomNumber++;
    }
    public String sameroomBooked(Boolean sameRoom) {
        if(!sameRoom)
         standardRooms -= 1;
        return STANDARD_ROOM + standardRoomNumber;
    }

    @Override
    public Boolean CheckIfTheresRoomAvailable(int attendee)
        {
            return standardRooms >= attendee;
        }

    @Override
    public int getRoomNumber() {
        return standardRooms;
    }
}
