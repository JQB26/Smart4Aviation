package com.szczepanek.smart4aviation.cargos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szczepanek.smart4aviation.cargos.cargo.Cargo;
import com.szczepanek.smart4aviation.cargos.cargo.item.Item;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Cargos {
    private List<Cargo> cargoList;
    private String filePath = "src/main/resources/jsonfiles/cargos.json";

    public void DownloadData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            cargoList = Arrays.asList(objectMapper.readValue(file, Cargo[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double[] GetWeight(int flightId) {
        // total_weight {cargo_weight, baggage_weight, total_weight}
        double[] total_weight = new double[]{0, 0, 0};
        for (Cargo cargo : cargoList) {
            if (Integer.parseInt(cargo.getFlightId()) == flightId) {
                //cargo weight
                for (int i = 0; i < cargo.getCargo().length; i++) {
                    if (cargo.getCargo()[i].getWeightUnit().equals("kg")) {
                        total_weight[0] += Double.parseDouble(cargo.getCargo()[i].getWeight());
                    } else {
                        total_weight[0] += Double.parseDouble(cargo.getCargo()[i].getWeight()) * 0.45359237;
                    }
                }
                //baggage weight
                for (int i = 0; i < cargo.getBaggage().length; i++) {
                    if (cargo.getBaggage()[i].getWeightUnit().equals("kg")) {
                        total_weight[1] += Double.parseDouble(cargo.getBaggage()[i].getWeight());
                    } else {
                        total_weight[1] += Double.parseDouble(cargo.getBaggage()[i].getWeight()) * 0.45359237;
                    }
                }
            }
        }
        total_weight[2] = total_weight[0] + total_weight[1];
        return total_weight;
    }

    public int GetTotalNumberOfBaggage(int flightId) {
        int total_number = 0;
        for (Cargo cargo : cargoList) {
            if (Integer.parseInt(cargo.getFlightId()) == flightId) {
                for (Item item : cargo.getBaggage()) {
                    total_number += Integer.parseInt(item.getPieces());
                }
            }
        }
        return total_number;
    }


    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
