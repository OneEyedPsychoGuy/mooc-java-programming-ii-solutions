package FlightControl.domain;

public class Flight {
    private Airplane plane;
    private Place departure;
    private Place destination;

    public Flight(Airplane plane, Place departure, Place destination) {
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }

    public Airplane getAirplane() {
        return this.plane;
    }

    public Place getDeparture() {
        return this.departure;
    }

    public Place getDestination() {
        return this.destination;
    }

    @Override
    public String toString() {
        return this.plane + " (" + this.departure + "-" + this.destination + ")";
    }
}