package dsaassignment2.question2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Question2Main {
    private static Random rand = new Random();
    
    public static void main(String[] args) {
        ArrayHashTable<TestData> testHashTable = new ArrayHashTable<>();
        
        TestData test = new TestData();
        TestData testIdentical = new TestData(test.getRandomData());
        TestData test2 = new TestData();
        TestData test3 = new TestData();
        TestData test4 = new TestData();
        TestData notInTable = new TestData();
        
        boolean addTrue = testHashTable.add(test);
        System.out.println("addTrue: " + addTrue);
        boolean addFalse = testHashTable.add(test);
        System.out.println("addFalse: " + addFalse);
        System.out.println("1: " + testHashTable.size);
        
        boolean addIdentical = testHashTable.add(testIdentical);
        System.out.println("addIdentical: " + addIdentical);
        System.out.println("2: " + testHashTable.size);
        
        testHashTable.add(test2);
        testHashTable.add(test3);
        testHashTable.add(test4);
        System.out.println("5: " + testHashTable.size);
        
        System.out.println("In: " + testHashTable.contains(test));
        boolean notInContains = testHashTable.contains(notInTable);
        System.out.println("Not in: " + notInContains);
        
        boolean removeTrue = testHashTable.remove(test);
        System.out.println("removeTrue: " + removeTrue);
        System.out.println("4: " + testHashTable.size);
        
        boolean removeFalse = testHashTable.remove(notInTable);
        System.out.println("removeFalse: " + removeFalse);
        System.out.println("4: " + testHashTable.size);
        
        boolean removeIdentical = testHashTable.remove(testIdentical);
        System.out.println("removeIdentical: " + removeIdentical);
        
        testHashTable.remove(test2);
        testHashTable.remove(test3);
        testHashTable.remove(test4);
        System.out.println("0: " + testHashTable.size);
        
        int[] sizes = new int[] {
            1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
            10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000
        };
        testHashTable(sizes);
    }
    
    private static void testHashTable(int[] sizes) {
        ArrayList<HashAnalysisPlot> addPlots = new ArrayList<>();
        ArrayList<HashAnalysisPlot> removePlots = new ArrayList<>();
        for (int size : sizes) {
            Integer[] randomData = generateRandom(size);
            ArrayHashTable<Integer> table = new ArrayHashTable<>();
            addPlots.add(hashTableAddCase(randomData, table));
            removePlots.add(hashTableRemoveCase(randomData, table));
            table = null;
            System.gc();
        }
        
        writeToCSV("hashTableAdd", addPlots);
        writeToCSV("hashTableRemove", removePlots);
    }
    
    private static HashAnalysisPlot hashTableAddCase(Integer[] data, 
            ArrayHashTable<Integer> table) {
        double sum = 0, s = 0;
        double sumSquared = 0;
        for (Integer i : data) {
            long t1 = System.nanoTime();
            table.add(i);
            long t2 = System.nanoTime() - t1;
            
            double sumToAdd = t2 / 1000000.0;
            sum += sumToAdd;
            sumSquared += sumToAdd * sumToAdd;
        }
        double mean = sum / data.length;
        double variance = sumSquared / data.length - (mean * mean);
        double stdDev = Math.sqrt(variance);
        double stdErr = stdDev / data.length;
        
        return new HashAnalysisPlot(data.length, mean, variance, 
                stdDev, stdErr);
    }
    
    private static HashAnalysisPlot hashTableRemoveCase(Integer[] data,
            ArrayHashTable<Integer> table) {
        double sum = 0, s = 0;
        double sumSquared = 0;
        for (Integer i : data) {
            long t1 = System.nanoTime();
            table.remove(i);
            long t2 = System.nanoTime() - t1;
            
            double sumToAdd = t2 / 1000000.0;
            sum += sumToAdd;
            sumSquared += sumToAdd * sumToAdd;
        }
        double mean = sum / data.length;
        double variance = sumSquared / data.length - (mean * mean);
        double stdDev = Math.sqrt(variance);
        double stdErr = stdDev / data.length;
        
        return new HashAnalysisPlot(data.length, mean, variance, 
                stdDev, stdErr);
    }
    
    private static Integer[] generateRandom(int size) {
        Integer[] numbers = new Integer[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Math.abs(rand.nextInt());
        }
        return numbers;
    }
    
    private static void writeToCSV(String name,
            ArrayList<HashAnalysisPlot> plots) {
        try {
            PrintWriter pw = new PrintWriter(new File(name + ".csv"));

            StringBuilder sb = new StringBuilder();
            sb.append("size, mean, variance, stdDev, stdErr\n");

            for (HashAnalysisPlot plot : plots) {
                sb.append(plot.getSize());
                sb.append(", ");
                sb.append(plot.getMean());
                sb.append(", ");
                sb.append(plot.getVar());
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
