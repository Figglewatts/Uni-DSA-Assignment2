package dsaassignment2.question2;

import java.util.Random;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class TestData {
    private static Random rand = new Random();
    
    private int randomData;
    
    public TestData() {
        // arbitrary high value chosen for greater variety
        randomData = rand.nextInt(10000);
    }
    public TestData(int data) {
        randomData = data;
    }

    public int getRandomData() {
        return randomData;
    }
}
