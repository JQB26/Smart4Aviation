import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Flights {
    private List<Flight> flightList;
    private String filePath = "src/main/resources/jsonfiles/flights.json";

    public void DownloadData(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            flightList = Arrays.asList(objectMapper.readValue(file, Flight[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int GetFlightId(int flightNumber, String date){
        for(Flight flight: flightList){
            if(flight.getFlightNumber().equals(Integer.toString(flightNumber)) && (flight.getDepartureDate().substring(0,10)).equals(date)){
                return Integer.parseInt(flight.getFlightId());
            }
        }
        return -1;
    }

    public List<Integer> GetArrivingFlightsId(String IATACode, String date){
        List<Integer> flights_id = new ArrayList<>();
        for(Flight flight: flightList){
            if(flight.getArrivalAirportIATACode().equals(IATACode) && flight.getDepartureDate().substring(0,10).equals(date)){
                flights_id.add(Integer.parseInt(flight.getFlightId()));
            }
        }
        return flights_id;
    }

    public List<Integer> GetDepartingFlightsId(String IATACode, String date){
        List<Integer> flights_id = new ArrayList<>();
        for(Flight flight: flightList){
            if(flight.getDepartureAirportIATACode().equals(IATACode) && flight.getDepartureDate().substring(0,10).equals(date)){
                flights_id.add(Integer.parseInt(flight.getFlightId()));
            }
        }
        return flights_id;
    }


    public List<Flight> getFlightList() {
        return flightList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
