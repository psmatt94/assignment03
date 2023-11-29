package ie.cs3318.p09;

public class ColourTable {
    private final int[] colourPalette;

    public ColourTable(int size) {
        if (!isPowerOfTwo(size) || size <= 1 || size >= 1025) {
            throw new IllegalArgumentException("Size must be a power of two, greater than 1 and less than 1025");
        }
        this.colourPalette = new int[size];
        java.util.Arrays.fill(colourPalette, -1);
    }

    public void add(int index, int colour) {
        if (index < 0 || index >= colourPalette.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (containsColour(colour)) {
            throw new IllegalArgumentException("Colour already exists in the table");
        }
        colourPalette[index] = colour;
    }

    public int getColour(int index) {
        if (index < 0 || index >= colourPalette.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return colourPalette[index];
    }

    private boolean isPowerOfTwo(int number) {
        return (number & (number - 1)) == 0;
    }

    private boolean containsColour(int colour) {
        for (int existingColour : colourPalette) {
            if (existingColour == colour) {
                return true;
            }
        }
        return false;
    }
}
