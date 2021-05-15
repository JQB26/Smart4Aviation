import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Flights {
    private List<Flight> flightList;

    public void DownloadData(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/jsonfiles/flights.json");
            flightList = Arrays.asList(objectMapper.readValue(file, Flight[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int GetFlightId(int flightNumber, String date){
        for(Flight flight: flightList){
            if(flight.getFlightNumber().equals(Integer.toString(flightNumber)) && flight.getDepartureDate().equals(date)){
                return Integer.parseInt(flight.getFlightId());
            }
        }
        return -1;
    }
}
