import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main driver for our sorting algorithms.
 * Only functionality is to call various algorithms.
 * @author Alex Merk
 * @author Nicole Kauer
 */
public class ExperimentDriver {

    public static Data data;
    public static long runtime1;
    public static long runtime2;
    public static long runtime3;
    public static long runtime4;
    public static long runtime5;
    public static long baseline;
    public static int experiment;
    public static StringBuilder results = new StringBuilder();

    /**
     * Just main.
     */
    public static void main(String[] args) {
        runTime_dataSize();
//        runTime_degSort();
//        memUse_dataSize();
//        memUse_degSort();
        data = new Data(1);
        data.quickSort(data.dataOne, 0, data.dataOne.length - 1);
    }

    private static void runTime_dataSize() {
        experiment = 1;
        //runTimes(1);
        System.out.println(results.toString());
//        runTimes(2);
//        runTimes(3);
//        runTimes(4);
    }

    private static void runTimes(int dataSet) {
        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.insertionSort(data.dataOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.dataTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.dataThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.dataFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.dataFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("InsertionSort,"+experiment+",reversed,20000,0,0," + runtime1 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+",reversed,40000,0,0," + runtime2 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+",reversed,60000,0,0," + runtime3 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+",reversed,80000,0,0," + runtime4 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+",reversed,100000,0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataOne, data.dataOne.length);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataTwo, data.dataTwo.length);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataThree, data.dataThree.length);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataFour, data.dataFour.length);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataFive, data.dataFive.length);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("SelectionSort,"+experiment+",reversed,20000,0,0," + runtime1 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+",reversed,40000,0,0," + runtime2 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+",reversed,60000,0,0," + runtime3 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+",reversed,80000,0,0," + runtime4 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+",reversed,100000,0,0," + runtime5 / 5.0 + "\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.bubbleSort(data.dataOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.dataTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.dataThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.dataFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.dataFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("BubbleSort,"+experiment+",reversed,20000,0,0," + runtime1 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+",reversed,40000,0,0," + runtime2 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+",reversed,60000,0,0," + runtime3 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+",reversed,80000,0,0," + runtime4 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+",reversed,100000,0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.mergeSort(data.dataOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.dataTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.dataThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.dataFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.dataFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("MergeSort,"+experiment+",reversed,20000,0,0," + runtime1 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+",reversed,40000,0,0," + runtime2 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+",reversed,60000,0,0," + runtime3 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+",reversed,80000,0,0," + runtime4 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+",reversed,100000,0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.quickSort(data.dataOne, 0, data.dataOne.length);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataTwo, 0, data.dataTwo.length);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataThree, 0, data.dataThree.length);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataFour, 0, data.dataFour.length);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataFive, 0, data.dataFive.length);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("QuickSort,"+experiment+",reversed,20000,0,0," + runtime1 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+",reversed,40000,0,0," + runtime2 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+",reversed,60000,0,0," + runtime3 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+",reversed,80000,0,0," + runtime4 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+",reversed,100000,0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");
    }

    private static void runTime_degSort() {
        data = new Data(1);
        data.semiSort();
        //track times here

        data = new Data(2);
        data.semiSort();
        //track times here

        data = new Data(3);
        data.semiSort();
        //track times here

        data = new Data(4);
        data.semiSort();
        //track times here
    }

    private static void memUse_dataSize() {
        data = new Data(1);
        data.genRevSynth();
        //track mem here

        data = new Data(2);
        data.genSin();
        //track mem here

        data = new Data(3);
        //track mem here

        data = new Data(4);
        //track mem here
    }

    private static void memUse_degSort() {
        data = new Data(1);
        data.semiSort();
        //track mem here

        data = new Data(2);
        data.semiSort();
        //track mem here

        data = new Data(3);
        data.semiSort();
        //track mem here

        data = new Data(4);
        data.semiSort();
        //track mem here
    }
}
