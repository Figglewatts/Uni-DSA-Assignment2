package dsaassignment2.question1;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Matrix {
    private final int[][] values;
    private final int size;
    
    public Matrix(int size) {
        this.values = new int[size][size];
        this.size = size;
    }
    
    public Matrix(int[][] values) {
        if (values.length != values[0].length)
            throw new IllegalArgumentException("Width and height must be equal");

        this.values = values;
        this.size = values.length;
    }
    
    public static Matrix defaultMatrix() {
        int[][] values = {
            { 1, 3, 7, 8, 8, 9, 12 },
            { 2, 4, 8, 9, 10, 30, 38 },
            { 4, 5, 10, 20, 29, 50, 60 },
            { 8, 10, 11, 30, 50, 60, 61 },
            { 11, 12, 40, 80, 90, 100, 111 },
            { 13, 15, 50, 100, 110, 112, 120 },
            { 22, 27, 61, 112, 119, 138, 153 }
        };
        return new Matrix(values);
    }
    
    public int get(int y, int x) {
        return this.values[y][x];
    }
    
    public int getSize() {
        return this.size;
    }
}
