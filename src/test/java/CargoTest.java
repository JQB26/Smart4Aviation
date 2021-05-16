import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CargoTest {

    @Test
    void getTotalNumberOfBaggage() {
        Item[] baggage = new Item[6];
        for(int i = 0; i < baggage.length; i++){
            baggage[i] = new Item(String.valueOf(i), "100", "kg", "300");
        }

        Item[] cargos = new Item[3];
        for(int i = 0; i < cargos.length; i++){
            cargos[i] = new Item(String.valueOf(i), "300", "kg", "500");
        }

        Cargo cargo = new Cargo("0", baggage, cargos);
        int total_number_of_baggage = cargo.GetTotalNumberOfBaggage();

        Assertions.assertEquals(300*6, total_number_of_baggage);
    }
}