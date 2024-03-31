import com.morsecodeapp.MorseController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseControllerTest {

    private MorseController morseController;

    @BeforeEach
    void setUp() {
        morseController = new MorseController();
    }

    @Test
    void translateToMorseTest() {
        assertEquals(".- ", morseController.translateToMorse("A"));
        assertEquals(".- ", morseController.translateToMorse("a"));
        assertEquals("-... ", morseController.translateToMorse("B"));
    }

    @Test
    void translateToCharTest() {
        assertEquals("A", morseController.translateToChar(".- "));
        assertEquals("B", morseController.translateToChar("-... "));
    }

}
