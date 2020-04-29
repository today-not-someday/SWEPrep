package OOPS.parkingLot;

public abstract class Account {
    private String userName;
    private String password;
    private One.AccountStatus status;
    private One.Person person;

    public boolean resetPassword();

    public static class ParkingAttendant extends Account {
            public bool processTicket(string TicketNumber);
        }
}
