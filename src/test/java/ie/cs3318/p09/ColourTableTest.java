package ie.cs3318.p09;




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ColourTableTest {

    @Test
    public void testValidColourTableSize() {
        assertDoesNotThrow(() -> new ColourTable(8), "Constructor should not throw an exception for a valid size");
    }

    @Test
    public void testInvalidColourTableSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3), "Constructor should throw IllegalArgumentException for a non-power-of-two size");
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(0), "Constructor should throw IllegalArgumentException for zero size");
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025), "Constructor should throw IllegalArgumentException for size greater than 1024");
    }
}
