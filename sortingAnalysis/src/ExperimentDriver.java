import java.io.*;
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
    public static long runtime6;
    public static long runtime7;
    public static long runtime8;
    public static long runtime9;
    public static long runtime10;

    public static long baseline;
    public static StringBuilder results = new StringBuilder("Algorithm,data set,data size,deg sorted,memory used,run time\n");;
    public static Runtime run = Runtime.getRuntime();

    /**
     * Just main.
     */
    public static void main(String[] args) {
        runTime_dataSize();
    }

    private static void runTime_dataSize() {
        dataSize(1, "reverse");
        System.out.println(results.toString());
        run.gc();
        dataSize(2, "2x^2 - x");
        System.out.println(results.toString());
        run.gc();
        dataSize(3, "census");
        System.out.println(results.toString());
        run.gc();
        dataSize(4, "weather");
        System.out.println(results.toString());
        run.gc();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Data/Results.csv"));
            writer.write(results.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dataSize(int dataSet, String data_set) {
        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = runtime6 = runtime7 = runtime8 = runtime9 = runtime10 = 0;
        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
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
        results.append("InsertionSort,"+data_set+","+data.dataOne.length+",0,"+data.iMem / 5.0+"," + runtime1 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.dataTwo.length+",0,"+data.iMem / 5.0+"," + runtime2 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.dataThree.length+",0,"+data.iMem / 5.0+"," + runtime3 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.dataFour.length+",0,"+data.iMem / 5.0+"," + runtime4 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.dataFive.length+",0,"+data.iMem / 5.0+"," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyOne);
            runtime6 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyTwo);
            runtime7 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyThree);
            runtime8 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyFour);
            runtime9 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.insertionSort(data.copyFive);
            runtime10 += (System.currentTimeMillis() - baseline);
        }
        results.append("InsertionSort,"+data_set+","+data.copyOne.length+",20,"+data.iMem/5.0+"," + runtime6 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.copyTwo.length+",40,"+data.iMem/5.0+"," + runtime7 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.copyThree.length+",60,"+data.iMem/5.0+"," + runtime8 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.copyFour.length+",80,"+data.iMem/5.0+"," + runtime9 / 5.0 + "\n");
        results.append("InsertionSort,"+data_set+","+data.copyFive.length+",100,"+data.iMem/5.0+"," + runtime10 / 5.0 + "\n");
        results.append("\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = runtime6 = runtime7 = runtime8 = runtime9 = runtime10 = 0;
        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
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
        results.append("SelectionSort,"+data_set+","+data.dataOne.length+",0,"+data.sMem/5.0+"," + runtime1 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.dataTwo.length+",0,"+data.sMem/5.0+"," + runtime2 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.dataThree.length+",0,"+data.sMem/5.0+"," + runtime3 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.dataFour.length+",0,"+data.sMem/5.0+"," + runtime4 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.dataFive.length+",0,"+data.sMem/5.0+"," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyOne);
            runtime6 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyTwo);
            runtime7 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyThree);
            runtime8 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyFour);
            runtime9 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.selectionSort(data.copyFive);
            runtime10 += (System.currentTimeMillis() - baseline);
        }
        results.append("SelectionSort,"+data_set+","+data.copyOne.length+",20,"+data.sMem/5.0+"," + runtime6 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.copyTwo.length+",40,"+data.sMem/5.0+"," + runtime7 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.copyThree.length+",60,"+data.sMem/5.0+"," + runtime8 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.copyFour.length+",80,"+data.sMem/5.0+"," + runtime9 / 5.0 + "\n");
        results.append("SelectionSort,"+data_set+","+data.copyFive.length+",100,"+data.sMem/5.0+"," + runtime10 / 5.0 + "\n");
        results.append("\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = runtime6 = runtime7 = runtime8 = runtime9 = runtime10 = 0;
        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
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
        results.append("BubbleSort,"+data_set+","+data.dataOne.length+",0,"+data.bMem/5.0+"," + runtime1 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.dataTwo.length+",0,"+data.bMem/5.0+"," + runtime2 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.dataThree.length+",0,"+data.bMem/5.0+"," + runtime3 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.dataFour.length+",0,"+data.bMem/5.0+"," + runtime4 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.dataFive.length+",0,"+data.bMem/5.0+"," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyOne);
            runtime6 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyTwo);
            runtime7 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyThree);
            runtime8 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyFour);
            runtime9 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.bubbleSort(data.copyFive);
            runtime10 += (System.currentTimeMillis() - baseline);
        }
        results.append("BubbleSort,"+data_set+","+data.copyOne.length+",20,"+data.bMem/5.0+"," + runtime6 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.copyTwo.length+",40,"+data.bMem/5.0+"," + runtime7 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.copyThree.length+",60,"+data.bMem/5.0+"," + runtime8 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.copyFour.length+",80,"+data.bMem/5.0+"," + runtime9 / 5.0 + "\n");
        results.append("BubbleSort,"+data_set+","+data.copyFive.length+",100,"+data.bMem/5.0+"," + runtime10 / 5.0 + "\n");
        results.append("\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = runtime6 = runtime7 = runtime8 = runtime9 = runtime10 = 0;
        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
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
        results.append("MergeSort,"+data_set+","+data.dataOne.length+",0,"+data.mMem/5.0+"," + runtime1 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.dataTwo.length+",0,"+data.mMem/5.0+"," + runtime2 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.dataThree.length+",0,"+data.mMem/5.0+"," + runtime3 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.dataFour.length+",0,"+data.mMem/5.0+"," + runtime4 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.dataFive.length+",0,"+data.mMem/5.0+"," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyOne);
            runtime6 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyTwo);
            runtime7 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyThree);
            runtime8 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyFour);
            runtime9 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.mergeSort(data.copyFive);
            runtime10 += (System.currentTimeMillis() - baseline);
        }
        results.append("MergeSort,"+data_set+","+data.copyOne.length+",20,"+data.mMem/5.0+"," + runtime6 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.copyTwo.length+",40,"+data.mMem/5.0+"," + runtime7 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.copyThree.length+",60,"+data.mMem/5.0+"," + runtime8 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.copyFour.length+",80,"+data.mMem/5.0+"," + runtime9 / 5.0 + "\n");
        results.append("MergeSort,"+data_set+","+data.copyFive.length+",100,"+data.mMem/5.0+"," + runtime10 / 5.0 + "\n");
        results.append("\n");
        results.append("\n");

        data = new Data(dataSet);
        baseline = runtime1 = runtime2 = runtime3 = runtime4 = runtime5 = runtime6 = runtime7 = runtime8 = runtime9 = runtime10 = 0;
        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
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
        results.append("QuickSort,"+data_set+","+data.dataOne.length+",0,"+data.qMem/5.0+"," + runtime1 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.dataTwo.length+",0,"+data.qMem/5.0+"," + runtime2 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.dataThree.length+",0,"+data.qMem/5.0+"," + runtime3 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.dataFour.length+",0,"+data.qMem/5.0+"," + runtime4 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.dataFive.length+",0,"+data.qMem/5.0+"," + runtime5 / 5.0 + "\n");
        results.append("\n");

        data.iMem = data.sMem = data.bMem = data.mMem = data.qMem = 0;
        for (int i = 0; i < 5; i++) {
            baseline = System.currentTimeMillis();
            data.quickSort(data.copyOne, 0, data.copyOne.length - 1);
            runtime6 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyTwo, 0, data.copyTwo.length - 1);
            runtime7 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyThree, 0, data.copyThree.length - 1);
            runtime8 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyFour, 0, data.copyFour.length - 1);
            runtime9 += (System.currentTimeMillis() - baseline);

            baseline = System.currentTimeMillis();
            data.quickSort(data.copyFive, 0, data.copyFive.length - 1);
            runtime10 += (System.currentTimeMillis() - baseline);
        }
        results.append("QuickSort,"+data_set+","+data.copyOne.length+",20,"+data.qMem/5.0+"," + runtime6 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.copyTwo.length+",40,"+data.qMem/5.0+"," + runtime7 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.copyThree.length+",60,"+data.qMem/5.0+"," + runtime8 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.copyFour.length+",80,"+data.qMem/5.0+"," + runtime9 / 5.0 + "\n");
        results.append("QuickSort,"+data_set+","+data.copyFive.length+",100,"+data.qMem/5.0+"," + runtime10 / 5.0 + "\n");
        results.append("\n");
    }
}
