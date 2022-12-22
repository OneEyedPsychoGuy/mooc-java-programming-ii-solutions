package FlightControl.domain;

public class Flight {
    private Airplane plane;
    private Place departure;
    private Place arrival;

    public Flight(Airplane plane, Place departure, Place arrival) {
        this.plane = plane;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airplane getAirplane() {
        return this.plane;
    }

    public Place getDeparture() {
        return this.departure;
    }

    public Place getArrival() {
        return this.arrival;
    }

    @Override
    public String toString() {
        return this.plane + " (" + this.departure + "-" + this.arrival + ")";
    }
}