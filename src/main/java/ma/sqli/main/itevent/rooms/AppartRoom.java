package ma.sqli.main.itevent.rooms;

import static ma.sqli.main.itevent.constants.Contants.APPART_START_NUMBER;

public class AppartRoom implements Room{
    private int appartsRooms;
    private int appartsRoomNumber;

    private final String APPART_ROOM = "Apart N°";
    private AppartRoom(){}
    public AppartRoom(int appartsRooms)
    {
        appartsRoomNumber = APPART_START_NUMBER;
        this.appartsRooms = appartsRooms;
    }
    @Override
    public String roomBooked() {
        appartsRooms -= 1;
        return APPART_ROOM + appartsRoomNumber++;
    }

    @Override
    public String sameroomBooked(Boolean sameRoom) {
        if(!sameRoom)
        appartsRooms -= 1;
        return APPART_ROOM + appartsRoomNumber;
    }

    @Override
    public Boolean CheckIfTheresRoomAvailable(int attendee)
    {
        return appartsRooms >= attendee;
    }

    @Override
    public int getRoomNumber() {
        return appartsRooms;
    }
}
