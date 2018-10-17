/**
 * Main driver for our sorting algorithms.
 * Only functionality is to call various algorithms.
 * @author Alex Merk
 * @author Nicole Kauer
 */
public class ExperimentDriver {

    /**
     * Just main.
     */
    public static void main(String[] args) {
        Data a = new Data();
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
