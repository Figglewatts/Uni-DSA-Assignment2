package dsaassignment2.question1;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class Searches {
    public interface Search {
        public boolean search(Matrix a, int n, int p);
    }

    static class DSearch implements Search {
        @Override
        public boolean search(Matrix a, int n, int p) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a.get(i, j) == p) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    static class D1Search implements Search {
        @Override
        public boolean search(Matrix a, int n, int p) {
            for (int i = 0; i < n; i++) {
                if (binarySearch(i, p, n, a)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    static class D2Search implements Search {
        @Override
        public boolean search(Matrix a, int n, int p) {
            int row = 0;
            int col = n - 1;
            while (row < n && col > 0) {
                int elem = a.get(row, col);

                if (elem < p) {
                    row++;
                } else if (elem > p) {
                    col--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
    
    private static boolean binarySearch(int rowNum, int p, int n, Matrix a) {
        boolean found = false;
        int i = 0;
        int min = 0;
        int max = n-1;
        while (found == false && i < n) {
            int guessIndex = (min + max) / 2;
            int guess = a.get(rowNum, guessIndex);
            
            if (guess == p) found = true;
            else if (guess < p) min = guessIndex + 1;
            else max = guessIndex - 1;
            i++;
        }
        return found;
    }
}