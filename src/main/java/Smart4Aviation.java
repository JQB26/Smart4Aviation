import java.util.Arrays;

public class Smart4Aviation {

    public static void main(String[] args){

        /*
        Flights flights = new Flights();
        flights.DownloadData();
        //System.out.println(flights.GetFlightId(2153,"2018-01-22T08:52:15 -01:00"));

        Cargos cargos = new Cargos();
        cargos.DownloadData();

        System.out.println(flights.GetFlightId(2153,"2018-01-22"));

        //System.out.println(cargos.GetBaggageWeight_kg(flights.GetFlightId(3561,"2018-11-13T02:36:36 -01:00")));

        //System.out.println(flights.GetNumberOfDepartures("SEA"));*/

        FinalApp finalApp = new FinalApp();

        System.out.println(Arrays.toString(finalApp.GetFlightWeight(2943, "2017-07-15")));
        System.out.println(Arrays.toString(finalApp.GetNumberOfFlightsAndBaggage("SEA", "2017-07-15")));

    }
}
