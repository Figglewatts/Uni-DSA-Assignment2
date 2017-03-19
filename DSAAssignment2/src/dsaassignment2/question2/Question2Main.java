package dsaassignment2.question2;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Question2Main {
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
        System.out.println("Not in: " + testHashTable.contains(notInTable));
        
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
    }
}
