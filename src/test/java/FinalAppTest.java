import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalAppTest {
    FinalApp finalApp = new FinalApp();

    @Test
    void getFlightWeight() {
        finalApp.setFlightsFilePath("src/test/java/flightsTest_data.json");
        finalApp.setCargosFilePath("src/test/java/cargosTest_data.json");
        finalApp.DownloadData();

        double[] result = finalApp.GetFlightWeight(3561,"2018-11-13");
        double[] expected = new double[3];
        expected[0] = 215+173*0.45359237;
        expected[1] = 216*0.45359237+976;
        expected[2] = expected[0]+expected[1];

        //cargo weight test
        Assertions.assertEquals(expected[0],result[0]);
        //baggage weight test
        Assertions.assertEquals(expected[1],result[1]);
        //total weight test
        Assertions.assertEquals(expected[2],result[2]);
    }

    @Test
    void getNumberOfFlightsAndBaggage() {
        finalApp.setFlightsFilePath("src/test/java/flightsTest_data.json");
        finalApp.setCargosFilePath("src/test/java/cargosTest_data.json");
        finalApp.DownloadData();

        int[] result = finalApp.GetNumberOfFlightsAndBaggage("GDN","2018-11-13");
        int[] expected = new int[] {0,1,266+208,0};

        //flights departing test
        Assertions.assertEquals(expected[0],result[0]);
        //flights arriving test
        Assertions.assertEquals(expected[1],result[1]);
        //total number of baggage arriving test
        Assertions.assertEquals(expected[2],result[2]);
        //total number of baggage departing test
        Assertions.assertEquals(expected[3],result[3]);
    }
}