import java.util.List;

public class FinalApp {
    private final Flights flights;
    private final Cargos cargos;

    public FinalApp() {
        flights = new Flights();
        cargos = new Cargos();
    }

    public void DownloadData(){
        flights.DownloadData();
        cargos.DownloadData();
    }

    // returns {cargo_weight, baggage_weight, total_weight}
    public double[] GetFlightWeight(int flightNumber, String date){
        return cargos.GetWeight(flights.GetFlightId(flightNumber, date));
    }

    // returns {number_of_departing_flights, number_of_arriving_flights, number_of_baggage_arriving, number_of_baggage_departing}
    public int[] GetNumberOfFlightsAndBaggage(String IATACode, String date){
        int[] result = new int[4];

        List<Integer> arriving_flights = flights.GetArrivingFlightsId(IATACode, date);
        result[1] = arriving_flights.size();
        for(int flightId: arriving_flights){
            result[2] += cargos.GetTotalNumberOfBaggage(flightId);
        }

        List<Integer> departing_flights = flights.GetDepartingFlightsId(IATACode, date);
        result[0] = departing_flights.size();
        for(int flightId: departing_flights){
            result[3] += cargos.GetTotalNumberOfBaggage(flightId);
        }

        return result;
    }

    public void setFlightsFilePath(String filePath) {
        flights.setFilePath(filePath);
    }

    public void setCargosFilePath(String filePath) {
        cargos.setFilePath(filePath);
    }


    public Flights getFlights() {
        return flights;
    }

    public Cargos getCargos() {
        return cargos;
    }
}
