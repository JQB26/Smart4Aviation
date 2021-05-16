import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CargosTest {

    Cargos cargos = new Cargos();


    @Test
    void getWeight() {
        cargos.setFilePath("src/test/java/cargosTest_data.json");
        cargos.DownloadData();
        double[] result = cargos.GetWeight(0);
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
    void getTotalNumberOfBaggage() {
        cargos.setFilePath("src/test/java/cargosTest_data.json");
        cargos.DownloadData();
        int result = cargos.GetTotalNumberOfBaggage(1);
        int expected = 322+520;

        Assertions.assertEquals(expected,result);
    }
}