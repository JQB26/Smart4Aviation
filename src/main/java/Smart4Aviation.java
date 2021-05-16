import java.util.Arrays;

public class Smart4Aviation {

    public static void main(String[] args){


        FinalApp finalApp = new FinalApp();

        System.out.println(Arrays.toString(finalApp.GetFlightWeight(2943, "2017-07-15")));
        System.out.println(Arrays.toString(finalApp.GetNumberOfFlightsAndBaggage("SEA", "2017-07-15")));

    }
}
