/*
Hash Table interface for the DS&A labs, week 1, semester 2. Note the emphasis here
is to get you to implement the algorithms, not write fancy code (although feel free to
do so! There are exercises for Programming 2 to engineer it more.
 */
package dsaassignment2.question2;

/**
 *
 * @author ajb
 */
public abstract class HashTable<T extends Object> {

    int capacity;
    int size;
    
    public HashTable(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    /**
     * Adds the specified element to this hash table if it is not already
     * present
     *
     * @param obj
     * @return true if the element is successfully added
     */
    public abstract boolean add(T obj);

    /**
     *
     * @param obj
     * @return true if this hash table contains the specified element
     */
    public abstract boolean contains(T obj);

    /**
     *
     * @param obj
     * @return Removes the specified element from this set if it is present
     */
    public abstract boolean remove(T obj);

}
