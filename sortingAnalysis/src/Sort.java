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
        experiment();
    }

    /**
     * Runs the experiments and tracks overall run-times and memory usage.
     * SUBJECT TO CHANGE
     */
    private void experiment() {
        //Set of experiments on first data set.
        //buildReal1();
        runTime_dataSize();
        runTime_degSort();
        memUse_dataSize();
        memUse_degSort();

        //Set of experiments on second data set.
        //buildReal2();
        runTime_dataSize();
        runTime_degSort();
        memUse_dataSize();
        memUse_degSort();

        //Set of experiments on third data set.
        //buildSynthetic1();
        runTime_dataSize();
        runTime_degSort();
        memUse_dataSize();
        memUse_degSort();

        //Set of experiments on 4th data set.
        //buildSynthetic2();
        runTime_dataSize();
        runTime_degSort();
        memUse_dataSize();
        memUse_degSort();
    }

    /**
     * Fills the array with the first real world data set.
     */
    private void buildReal1() {
        data = new Object[real1Size];
    }

    /**
     * Fills the array with the second real world data set.
     */
    private void buildReal2() {
        data = new Object[real2Size];
    }

    /**
     * Fills the array with the first synthetic data set.
     */
    private void buildSynthetic1() {
        data = new Object[synthetic1Size];
    }

    /**
     * Fills the array with the second synthetic data set.
     */
    private void buildSynthetic2() {
        data = new Object[synthetic2Size];
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
