package dsaassignment2.question1;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Matrix {
    private final int[][] values;
    private final int width;
    private final int height;
    
    public Matrix(int h, int w) {
        if (h != w) 
            throw new IllegalArgumentException("Width and height must be equal");
        this.values = new int[h][w];
        this.width = w;
        this.height = h;
    }
    
    public Matrix(int[][] values) {
        this.values = values;
        this.height = values.length;
        this.width = values[0].length;
        if (this.height != this.width) 
            throw new IllegalArgumentException("Width and height must be equal");
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
}
