import jdk.nashorn.api.tree.ForInLoopTree;

/**
 * Main class containing our sorting algorithms.
 * @author Alex Merk.
 * @author Nicole Kauer.
 */
public class Sort {

    /**
     * Array to hold all of the data sets.
     */
    private Object data[];

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
        buildReal1();
        buildReal2();
        buildSynthetic1();
        buildSynthetic2();
    }

    private void buildReal1() {
        data = new Object[real1Size];
    }

    private void buildReal2() {
        data = new Object[real2Size];
    }

    private void buildSynthetic1() {
        data = new Object[synthetic1Size];
    }

    private void buildSynthetic2() {
        data = new Object[synthetic2Size];
    }

    /**
     * Runs the experiments and tracks overall run-times and memory usage.
     * SUBJECT TO CHANGE
     */
    private void experiment() {

    }

    /**
     * Experiment controller for the first real data set.
     */
    private void realData1Experiments() {

    }

    /**
     * Experiment controller for the second real data set.
     */
    private void realData2Experiments() {

    }

    /**
     * Experiment controller for the first synthetic data set.
     */
    private void synetheticData1Experiment() {

    }

    /**
     * Experiment controller for the second synthetic data set.
     */
    private void syntheticData2Experiment() {

    }

    /**
     * Analyzes the run time of the sorting algorithms based on the data size of the input.
     */
    private void runTime_dataSize() {

    }

    /**
     * Analyzes the run time of the sorting algorithms based on the degree of sortedness of the input.
     */
    private void runTime_degSort() {

    }

    /**
     * Analyzes the memory usage of the sorting algorithms based on the data size of the input.
     */
    private void memUse_dataSize() {

    }

    /**
     * Analyzes the memory usage of the sorting algorithms based on the degree of sortedness of the input.
     */
    private void memUse_degSort() {

    }
}
