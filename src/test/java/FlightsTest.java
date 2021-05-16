import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlightsTest {

    Flights flights = new Flights();

    @Test
    void getFlightId() {
        flights.DownloadData();
        Assertions.assertEquals(2,flights.GetFlightId(5560,"2015-03-16"));
    }

    @Test
    void getArrivingFlightsId() {
        flights.setFilePath("src/test/java/flightsTest_data.json");
        flights.DownloadData();
        java.util.List<Integer> result = flights.GetArrivingFlightsId("PPX", "2017-07-15");
        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals(1,result.get(0));
    }

    @Test
    void getDepartingFlightsId() {
        flights.setFilePath("src/test/java/flightsTest_data.json");
        flights.DownloadData();
        java.util.List<Integer> result = flights.GetDepartingFlightsId("SEA", "2017-07-15");
        Assertions.assertEquals(2,result.size());
        Assertions.assertEquals(1,result.get(0));
    }
}