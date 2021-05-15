import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Cargos {

    private List<Cargo> cargoList;

    public void DownloadData(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/jsonfiles/cargos.json");
            cargoList = Arrays.asList(objectMapper.readValue(file, Cargo[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double GetCargoWeight_kg(int flightId){
        double total_weight = -1;
        for(Cargo cargo: cargoList){
            if(Integer.parseInt(cargo.getFlightId()) == flightId){
                total_weight = 0;
                for(int i = 0; i < cargo.getCargo().length; i++){
                    if(cargo.getCargo()[i].getWeightUnit().equals("kg")){
                        total_weight += Double.parseDouble(cargo.getCargo()[i].getWeight());
                    }
                    else{
                        total_weight += Double.parseDouble(cargo.getCargo()[i].getWeight()) * 0.45359237;
                    }
                }
            }
        }
        return total_weight;
    }

    public double GetBaggageWeight_kg(int flightId){
        double total_weight = -1;
        for(Cargo cargo: cargoList){
            if(Integer.parseInt(cargo.getFlightId()) == flightId){
                total_weight = 0;
                for(int i = 0; i < cargo.getBaggage().length; i++){
                    if(cargo.getBaggage()[i].getWeightUnit().equals("kg")){
                        total_weight += Double.parseDouble(cargo.getBaggage()[i].getWeight());
                    }
                    else{
                        total_weight += Double.parseDouble(cargo.getBaggage()[i].getWeight()) * 0.45359237;
                    }
                }
            }
        }
        return total_weight;
    }

    public double GetTotalWeight_kg(int flightId){
        return GetBaggageWeight_kg(flightId) + GetCargoWeight_kg(flightId);
    }
}
