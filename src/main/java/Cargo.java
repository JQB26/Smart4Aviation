public class Cargo {

    private String flightId;
    private Item[] baggage;
    private Item[] cargo;


    public Cargo(String flightId, Item[] baggage, Item[] cargo) {
        this.flightId = flightId;
        this.baggage = baggage;
        this.cargo = cargo;
    }

    public Cargo() {
    }


    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Item[] getBaggage() {
        return baggage;
    }

    public void setBaggage(Item[] baggage) {
        this.baggage = baggage;
    }

    public Item[] getCargo() {
        return cargo;
    }

    public void setCargo(Item[] cargo) {
        this.cargo = cargo;
    }
}
