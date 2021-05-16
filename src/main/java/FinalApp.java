public class FinalApp {

    private final Flights flights;
    private final Cargos cargos;

    public FinalApp() {
        flights = new Flights();
        flights.DownloadData();

        cargos = new Cargos();
        cargos.DownloadData();
    }

    // returns [cargo_weight, baggage_weight, total_weight]
    public double[] GetFlightWeight(int flightNumber, String date){
        return cargos.GetWeight(flights.GetFlightId(flightNumber, date));
    }

    // returns [number_of_departing_flights, number_of_arriving_flights, number_of_baggage_arriving, number_of_baggage_departing]
    public int[] GetNumberOfFlightsAndBaggage(String IATACode, String date){
        int[] result = new int[4];

        int[] flights_number;
        flights_number = flights.GetNumberOfFlights(IATACode, date);
        result[0] = flights_number[0];
        result[1] = flights_number[1];

        for(int flightId: flights.GetArrivingFlightsId(IATACode, date)){
            result[2] += cargos.GetTotalNumberOfBaggage(flightId);
        }
        for(int flightId: flights.GetDepartingFlightsId(IATACode, date)){
            result[3] += cargos.GetTotalNumberOfBaggage(flightId);
        }

        return result;
    }
}
