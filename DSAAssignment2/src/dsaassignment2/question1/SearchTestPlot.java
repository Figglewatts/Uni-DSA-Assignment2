package dsaassignment2.question1;

/**
 *
 * @author Sam Gibson (100115871) <sam.gibson@uea.ac.uk>
 */
public class SearchTestPlot {
    private final double mean;
    private final double variance;
    private final double stdDev;
    private final double stdErr;
    
    public SearchTestPlot(double m, double var, double sDev, double sErr) {
        this.mean = m;
        this.variance = var;
        this.stdDev = sDev;
        this.stdErr = sErr;
    }
    
    public double getMean() {
        return mean;
    }

    public double getVariance() {
        return variance;
    }

    public double getStdDev() {
        return stdDev;
    }

    public double getStdErr() {
        return stdErr;
    }
}
