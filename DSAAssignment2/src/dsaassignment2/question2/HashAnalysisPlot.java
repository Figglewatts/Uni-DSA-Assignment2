package dsaassignment2.question2;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class HashAnalysisPlot {
    private final int size;
    private final double mean;
    private final double var;
    private final double stdDev;
    private final double stdErr;
    
    public HashAnalysisPlot(int n, double m, double v, 
            double stdD, double stdE) {
        size = n;
        mean = m;
        var = v;
        stdDev = stdD;
        stdErr = stdE;
    }

    public int getSize() {
        return size;
    }

    public double getMean() {
        return mean;
    }

    public double getVar() {
        return var;
    }

    public double getStdDev() {
        return stdDev;
    }

    public double getStdErr() {
        return stdErr;
    }
}
