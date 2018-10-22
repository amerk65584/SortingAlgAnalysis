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
    public static StringBuilder results;
    public static Runtime run = Runtime.getRuntime();

    /**
     * Just main.
     */
    public static void main(String[] args) {
        runTime_dataSize();
//        runTime_degSort();
//        memUse_dataSize();
//        memUse_degSort();
    }

    private static void runTime_dataSize() {
        experiment = 1;
        dataSize(1, "reverse");
        System.out.println(results.toString());
        run.gc();
        experiment = 2;
        dataSize(2, "2x^2 - x");
        System.out.println(results.toString());
        run.gc();
        experiment = 3;
        dataSize(3, "census");
        System.out.println(results.toString());
        run.gc();
        experiment = 4;
        dataSize(4, "weather");
        System.out.println(results.toString());
        run.gc();
        experiment = 5;
        degSorted(1, "reverse");
        System.out.println(results.toString());
        run.gc();
        experiment = 6;
        degSorted(2, "2x^2 - x");
        System.out.println(results.toString());
        run.gc();
        experiment = 7;
        degSorted(3, "census");
        System.out.println(results.toString());
        run.gc();
        experiment = 8;
        degSorted(4, "weather");
        System.out.println(results.toString());
        run.gc();
    }

    private static void dataSize(int dataSet, String data_set) {
        data = new Data(dataSet);
        results = new StringBuilder();
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
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataOne.length+",0,0," + runtime1 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataTwo.length+",0,0," + runtime2 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataThree.length+",0,0," + runtime3 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataFour.length+",0,0," + runtime4 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataFive.length+",0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.dataFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataOne.length+",0,0," + runtime1 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataTwo.length+",0,0," + runtime2 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataThree.length+",0,0," + runtime3 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataFour.length+",0,0," + runtime4 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataFive.length+",0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

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
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataOne.length+",0,0," + runtime1 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataTwo.length+",0,0," + runtime2 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataThree.length+",0,0," + runtime3 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataFour.length+",0,0," + runtime4 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataFive.length+",0,0," + runtime5 / 5.0 + "\n");
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
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataOne.length+",0,0," + runtime1 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataTwo.length+",0,0," + runtime2 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataThree.length+",0,0," + runtime3 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataFour.length+",0,0," + runtime4 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataFive.length+",0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.quickSort(data.dataOne, 0, data.dataOne.length - 1);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataTwo, 0, data.dataTwo.length - 1);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataThree, 0, data.dataThree.length - 1);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataFour, 0, data.dataFour.length - 1);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.dataFive, 0, data.dataFive.length - 1);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataOne.length+",0,0," + runtime1 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataTwo.length+",0,0," + runtime2 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataThree.length+",0,0," + runtime3 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataFour.length+",0,0," + runtime4 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataFive.length+",0,0," + runtime5 / 5.0 + "\n");
        results.append("\n");
    }

    private static void degSorted(int dataSet, String data_set) {
        data = new Data(dataSet);
        data.semiSort();
        results = new StringBuilder();
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataOne.length+",20,0," + runtime1 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataTwo.length+",40,0," + runtime2 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataThree.length+",60,0," + runtime3 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataFour.length+",80,0," + runtime4 / 5.0 + "\n");
        results.append("InsertionSort,"+experiment+","+data_set+","+data.dataFive.length+",100,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        data.semiSort();
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataOne.length+",20,0," + runtime1 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataTwo.length+",40,0," + runtime2 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataThree.length+",60,0," + runtime3 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataFour.length+",80,0," + runtime4 / 5.0 + "\n");
        results.append("SelectionSort,"+experiment+","+data_set+","+data.dataFive.length+",100,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        data.semiSort();
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataOne.length+",20,0," + runtime1 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataTwo.length+",40,0," + runtime2 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataThree.length+",60,0," + runtime3 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataFour.length+",80,0," + runtime4 / 5.0 + "\n");
        results.append("BubbleSort,"+experiment+","+data_set+","+data.dataFive.length+",100,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        data.semiSort();
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyOne);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyTwo);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyThree);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyFour);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyFive);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataOne.length+",20,0," + runtime1 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataTwo.length+",40,0," + runtime2 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataThree.length+",60,0," + runtime3 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataFour.length+",80,0," + runtime4 / 5.0 + "\n");
        results.append("MergeSort,"+experiment+","+data_set+","+data.dataFive.length+",100,0," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data = new Data(dataSet);
        data.semiSort();
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.quickSort(data.copyOne, 0, data.copyOne.length - 1);
            runtime1 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyTwo, 0, data.copyTwo.length - 1);
            runtime2 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyThree, 0, data.copyThree.length - 1);
            runtime3 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyFour, 0, data.copyFour.length - 1);
            runtime4 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyFive, 0, data.copyFive.length - 1);
            runtime5 += (System.currentTimeMillis() - baseline);
        }
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataOne.length+",20,0," + runtime1 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataTwo.length+",40,0," + runtime2 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataThree.length+",60,0," + runtime3 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataFour.length+",80,0," + runtime4 / 5.0 + "\n");
        results.append("QuickSort,"+experiment+","+data_set+","+data.dataFive.length+",1000,0," + runtime5 / 5.0 + "\n");
        results.append("\n");
    }
}
