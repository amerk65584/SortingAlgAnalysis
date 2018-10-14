/**
 * Main class containing our sorting algorithms.
 * @author Alex Merk.
 * @author Nicole Kauer.
 */
public class Sort {

    /**
     * First real world data set.
     */
    private Object realData1[];

    /**
     * Second real world data set.
     */
    private Object realData2[];

    /**
     * First distribution data set.
     */
    private Object syntheticData1[];

    /**
     * Second distribution data set.
     */
    private Object syntheticData2[];

    /**
     * Holds the size of the data set for re-initialization.
     */
    private int real1Size;
    private int real2Size;
    private int synthetic1Size;
    private int synthetic2Size;

    /**
     * Makes calls to construct and fill data sets with values and perform the experiments.
     */
    public Sort() {
        super();
        construct();
        experiment();
    }

    /**
     * Calls methods to construct the 4 data sets from scratch.
     */
    private void construct() {
        realData1 = new Object[real1Size];
        realData2 = new Object[real2Size];
        syntheticData1 = new Object[synthetic1Size];
        syntheticData2 = new Object[synthetic2Size];
    }

    /**
     * Runs the experiments and tracks overall run-times and memory usage.
     * SUBJECT TO CHANGE
     */
    private void experiment() {

    }
}
