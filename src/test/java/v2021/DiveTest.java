package v2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiveTest {

    private Dive dive;

    @BeforeEach
    void setUp() {
        dive = new Dive();
    }

    @Test
    void doExample() {
        List<String> input = List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");
        int result = dive.doWork(input);
        assertEquals(150, result);
    }

    @Test
    void doReal() {
        List<String> input = dive.getInput();
        int result = dive.doWork(input);
        System.out.println(result);
    }

    @Test
    void doAimExample() {
        List<String> input = List.of("forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2");
        int result = dive.doWorkWithAim(input);
        assertEquals(900, result);
    }

    @Test
    void doAimWork() {
        List<String> input = dive.getInput();
        int result = dive.doWorkWithAim(input);
        System.out.println(result);
    }
}