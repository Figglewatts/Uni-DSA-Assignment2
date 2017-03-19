package dsaassignment2.question2;

import java.util.Arrays;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class ArrayHashTable<T extends Object> extends HashTable<T> {
    private final static int DEFAULT_CAPACITY = 10;
    
    private Object[][] table;
    private final int chainSize = 5;
    private int[] counts;
    
    public ArrayHashTable() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayHashTable(int newCapacity) {
        super(newCapacity);
        table = new Object[capacity][];
        counts = new int[capacity];
    }

    @Override
    public int size() {
        return super.size();
    }
    
    @Override
    public boolean add(T obj) {
        int hash = arrayHash(obj);
        // if the bucket here doesn't exist
        if (table[hash] == null) {
            table[hash] = new Object[chainSize];
        }
        else if (inBucket(hash, obj)) return false; // should be O(n)
        
        if (counts[hash] > chainSize) {
            // if full, double its capacity
            table[hash] = Arrays.copyOf(table[hash], table[hash].length * 2);
        }
        
        table[hash][counts[hash]] = obj;
        counts[hash]++;
        size++;
        return true;
    }

    @Override
    public boolean contains(T obj) {
        return inBucket(arrayHash(obj), obj);
    }

    @Override
    public boolean remove(T obj) {
        int hash = arrayHash(obj);
        if (!inBucket(hash, obj)) return false;
        
        // we can now be sure the bucket at hash will exist
        return removeInBucket(hash, obj);
    }
    
    private int arrayHash(T obj) {
        return obj.hashCode() % capacity;
    }
    
    /**
     * Linear search the bucket to see if the object is present.
     * @param bucket The index of the bucket in the table.
     * @param obj The object to search for.
     * @return True if present, false otherwise.
     */
    private boolean inBucket(int bucket, T obj) {
        for (Object o : table[bucket]) {
            if (o.equals(obj)) return true;
        }
        return false;
    }
    
    private boolean removeInBucket(int bucket, T obj) {
        for (int i = 0; i < counts[bucket]; i++) {
            if (table[bucket][i].equals(obj)) {
                System.arraycopy(table[bucket], i + 1, table[bucket], i, 
                        counts[bucket] - i - 1);
                table[bucket][counts[bucket] - 1] = null;
                counts[bucket]--;
                size--;
                return true;
            }
        }
        return false;
    }
}
