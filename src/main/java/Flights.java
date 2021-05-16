import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
            if(flight.getFlightNumber().equals(Integer.toString(flightNumber)) && (flight.getDepartureDate().substring(0,10)).equals(date)){
                return Integer.parseInt(flight.getFlightId());
            }
        }
        return -1;
    }

    public int[] GetNumberOfFlights(String IATACode, String date){
        // total_number [number_of_departures, number_of_arrivals]
        int[] total_number = new int[] {0,0};
        for(Flight flight: flightList){
            if(flight.getDepartureDate().substring(0,10).equals(date)){
                if(flight.getDepartureAirportIATACode().equals(IATACode)){
                    total_number[0]++;
                }
                if(flight.getArrivalAirportIATACode().equals(IATACode)){
                    total_number[1]++;
                }
            }
        }
        return total_number;
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

}
