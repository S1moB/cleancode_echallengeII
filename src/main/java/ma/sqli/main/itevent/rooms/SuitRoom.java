package ma.sqli.main.itevent.rooms;

import static ma.sqli.main.itevent.constants.Contants.SUIT_START_NUMBER;

public class SuitRoom implements Room {
    private int suites;
    private int suitesNumber;

    private final String SUITES = "Suite N°";
    private SuitRoom(){}
    public SuitRoom(int suites)
    {
        suitesNumber = SUIT_START_NUMBER;
        this.suites = suites;
    }
    @Override
    public String roomBooked() {
        suites -= 1;
        return SUITES + suitesNumber++;
    }

    @Override
    public String sameroomBooked(Boolean sameRoom) {
        if(!sameRoom)
         suites -= 1;
        return SUITES + suitesNumber;
    }
    @Override
    public Boolean CheckIfTheresRoomAvailable(int attendee)
    {
        return suites >= attendee;
    }

    @Override
    public int getRoomNumber() {
        return suites;
    }
}
