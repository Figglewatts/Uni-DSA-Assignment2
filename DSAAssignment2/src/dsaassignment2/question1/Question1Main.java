package dsaassignment2.question1;

import dsaassignment2.question1.Searches.*;

/**
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Question1Main {
    public static void main (String[] args) {
        testAlgorithms(new int[] { 4, 12, 110, 5, 6, 111 } );
    }
    
    public static void testAlgorithms(int[] values) {
        Matrix m = Matrix.defaultMatrix();
        for (int i : values) {
            boolean dResult = findElementD(m, m.getSize(), i);
            boolean d1Result = findElementD1(m, m.getSize(), i);
            boolean d2Result = findElementD2(m, m.getSize(), i);
            
            System.out.printf("VALUE %d:\nd: %b\nd1: %b\nd2: %b\n\n", i, 
                dResult, d1Result, d2Result);
        }
    }
    
    public static void algorithmWorstCases(int[] n) {
        for (int i = 0; i < 3; i++) {
            for (int size : n) {
                
            }
        }
    }
    
    public static boolean findElementD(Matrix a, int n, int p) {
        Search d = new Searches.DSearch();
        return d.search(a, n, p);
    }
    
    public static boolean findElementD1(Matrix a, int n, int p) {
        Search d1 = new Searches.D1Search();
        return d1.search(a, n, p);
    }
    
    public static boolean findElementD2(Matrix a, int n, int p) {
        Search d2 = new Searches.D2Search();
        return d2.search(a, n, p);
    }
}
