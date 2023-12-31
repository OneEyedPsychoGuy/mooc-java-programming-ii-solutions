package FlightControl.logic;

import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import FlightControl.domain.Place;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class FlightControl {
    private Map<String, Flight> flights;
    private Map<String, Airplane> planes;
    private Map<String, Place> places;

    public FlightControl() {
        this.flights = new HashMap<>();
        this.planes = new HashMap<>();
        this.places = new HashMap<>();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Collection<Airplane> getAirplanes() {
        return this.planes.values();
    }

    public Collection<Place> getPlaces() {
        return this.places.values();
    }

    public Airplane getAirplane(String id) {
        return this.planes.get(id);
    }

    public void addAirplane(String id, int capacity) {
        this.planes.put(id, new Airplane(id, capacity));
    }

    public void addFlight(Airplane plane, String departure, String destination) {
        this.places.putIfAbsent(departure, new Place(departure));
        this.places.putIfAbsent(destination, new Place(destination));

        Flight flight = new Flight(plane, this.places.get(departure), this.places.get(destination));
        this.flights.put(flight.toString(), flight);
    }
}