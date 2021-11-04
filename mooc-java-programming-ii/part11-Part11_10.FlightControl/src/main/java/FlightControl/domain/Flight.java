package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private String departureAirportID;
    private String destinationAirportID;

    public Flight(Airplane airplane, String departureAirportID, String destinationAirportID) {
        this.airplane = airplane;
        this.departureAirportID = departureAirportID;
        this.destinationAirportID = destinationAirportID;
    }

    @Override
    public String toString() {
        return airplane.toString() + " (" + departureAirportID + "-" + destinationAirportID + ")";
    }
}
