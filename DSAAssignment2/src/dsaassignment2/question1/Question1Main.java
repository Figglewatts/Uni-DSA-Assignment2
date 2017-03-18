package dsaassignment2.question1;

import dsaassignment2.question1.Searches.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Question1Main {
    private static final int REP_COUNT = 10;
    private static final int P_VALUE = 30; // arbitrary
    
    public static void main (String[] args) {
        testAlgorithms(new int[] { 4, 12, 110, 5, 6, 111 } );
        
        int sizes[] = new int[] {
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            200, 300, 400, 500, 600, 700, 800, 900,
            1000, 2000, 3000, 4000
        };
        algorithmWorstCases(sizes, REP_COUNT, P_VALUE);
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
    
    public static void algorithmWorstCases(int[] sizes, int reps, int p) {
        Search[] searches = new Search[] {
            new DSearch("DSearch"),
            new D1Search("D1Search"),
            new D2Search("D2Search")
        };
        for (int i = 0; i < 3; i++) {
            ArrayList<SearchTestPlot> testPlots = new ArrayList<>();
            
            for (int n : sizes) {
                Matrix a = null;
                switch (i) {
                    case 0:
                    {
                        a = Matrix.worstCaseD(p, n);
                    } break;
                    case 1:
                    {
                        a = Matrix.worstCaseD1(p, n);
                    } break;
                    case 2:
                    {
                        a = Matrix.worstCaseD2(p, n);
                    } break;
                }
                
                testPlots.add(testAlgorithm(searches[i], reps, a, n, p));
            }
            
            writeToCSV(searches[i].name, testPlots);
        }
    }
    
    public static boolean findElementD(Matrix a, int n, int p) {
        Search d = new Searches.DSearch("");
        return d.search(a, n, p);
    }
    
    public static boolean findElementD1(Matrix a, int n, int p) {
        Search d1 = new Searches.D1Search("");
        return d1.search(a, n, p);
    }
    
    public static boolean findElementD2(Matrix a, int n, int p) {
        Search d2 = new Searches.D2Search("");
        return d2.search(a, n, p);
    }
    
    private static SearchTestPlot testAlgorithm(Search algorithm, int reps, 
            Matrix a, int n, int p) {
        double sum = 0, s = 0;
        double sumSquared = 0;
        for (int i = 0; i < reps; i++) {
            long t1 = System.nanoTime();
            algorithm.search(a, n, p);
            long t2 = System.nanoTime() - t1;
            
            double sumToAdd = t2 / 1000000.0;
            sum += sumToAdd;
            sumSquared += sumToAdd * sumToAdd;
        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        double stdDev = Math.sqrt(variance);
        double stdErr = stdDev / reps;

        return new SearchTestPlot(mean, variance, stdDev, stdErr);
    }
    
    private static void writeToCSV(String name, 
            ArrayList<SearchTestPlot> plots) {
        try {
            PrintWriter pw = new PrintWriter(new File(name + ".csv"));
            
            StringBuilder sb = new StringBuilder();
            sb.append("mean, variance, stdDev, stdErr\n");

            for (SearchTestPlot plot : plots) {
                sb.append(plot.getMean());
                sb.append(", ");
                sb.append(plot.getVariance());
                sb.append(", ");
                sb.append(plot.getStdDev());
                sb.append(", ");
                sb.append(plot.getStdErr());
                sb.append("\n");
            }

            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }
    }
}
