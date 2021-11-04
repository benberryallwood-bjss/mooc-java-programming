package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Airport;
import FlightControl.domain.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightManager {
    private Map<String, Airplane> airplanes;
    private Map<String, Airport> airports;
    private List<Flight> flights;

    public FlightManager() {
        airplanes = new HashMap<>();
        flights = new ArrayList<>();
        airports = new HashMap<>();
    }

    public void createAirplane(String airplaneID, String airplaneCapacity) {
        int airplaneCapacityInt = Integer.parseInt(airplaneCapacity);
        Airplane newAirplane = new Airplane(airplaneID, airplaneCapacityInt);
        airplanes.put(airplaneID, newAirplane);
    }

    public void createFlight(String airplaneID, String departureAirportID, String destinationAirportID) {
        Airplane airplane = airplanes.get(airplaneID);
        airports.putIfAbsent(departureAirportID, new Airport(departureAirportID));
        airports.putIfAbsent(destinationAirportID, new Airport(destinationAirportID));

        Flight newFlight = new Flight(airplane, departureAirportID, destinationAirportID);
        flights.add(newFlight);
    }

    public Map<String, Airplane> getAirplanes() {
        return airplanes;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
