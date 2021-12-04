package v2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GiantSquidTest {

    private GiantSquid giantSquid;

    @BeforeEach
    public void setup() {
        giantSquid = new GiantSquid("bingFieldExample.txt");
    }

    @Test
    public void testGetDrawInput() {
        giantSquid.setDrawInput("drawInputExample.txt");
        List<Integer> drawInput = giantSquid.getDrawInput();
    }


    @Test
    public void testGetBingoFieldsInput() {
        giantSquid.setBingoFields("bingoFieldExample.txt");
    }

    @Test
    public void testReal() {

    }

    @Test
    public void testExampleTwo() {

    }

    @Test
    void testRealTwo() {

    }
}