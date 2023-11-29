package ie.cs3318.p09;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ColourTableTest {
    private ColourTable table;

    @BeforeEach
    public void setUp() {
        table = new ColourTable(8); // Initialize with a table size of 8
    }

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

    @Test
    public void testAddingValidColour() {
        assertDoesNotThrow(() -> table.add(0, 0xFFFFFF), "Should not throw an exception when adding a valid colour");
        assertEquals(0xFFFFFF, table.getColour(0), "The colour should match what was added");
    }

    @Test
    public void testAddingColourOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> table.add(8, 0xFFFFFF), "Should throw IndexOutOfBoundsException when adding beyond table size");
    }


    @Test
    public void testAddingSameColourTwice() {
        int colour = 0xABCDEF;
        table.add(0, colour);
        assertThrows(IllegalArgumentException.class, () -> table.add(1, colour), "Should throw IllegalArgumentException when adding the same colour twice");
    }
}
