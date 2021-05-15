public class Smart4Aviation {

    public static void main(String[] args){
        Flights flights = new Flights();
        flights.DownloadData();
        System.out.println(flights.GetFlightId(2153,"2018-01-22T08:52:15 -01:00"));
    }
}
