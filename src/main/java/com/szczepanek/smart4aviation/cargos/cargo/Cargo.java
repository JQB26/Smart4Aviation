package com.szczepanek.smart4aviation.cargos.cargo;

import com.szczepanek.smart4aviation.cargos.cargo.item.Item;

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

    public int GetTotalNumberOfBaggage() {
        int total_number = 0;
        for (Item item : baggage) {
            total_number += Integer.parseInt(item.getPieces());
        }
        return total_number;
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
