import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class containing our sorting algorithms.
 * @author Alex Merk.
 * @author Nicole Kauer.
 */
public class Data {

    /**
     * Original array for data.
     */
    private int[] dataSin;
    private int[] revSorted;
    private int[] census;
    private int[] weather;

    /**
     * Makes calls to construct and fill data sets with values and perform the experiments.
     */
    public Data() {
        super();
        revSorted = new int[100000];
        for (int i = 0; i < revSorted.length; i++) {
            revSorted[i] = revSorted.length - i;
        }

        dataSin = new int[100000];
        for (int i = 0; i < dataSin.length; i++) {
            dataSin[i] = (int) (Math.floor(Math.sin(i) * Math.pow(i, 3)) + Math.ceil(Math.cos(i) * Math.pow(i, 2)));
        }
        census = new int[100000];
        weather = new int[100000];
        readFileOne("Data/USCensusWA_wage_100k.csv", census);
        readFileOne("Data/Weather_100k.csv", weather);

    }

    public void readFileOne(String file, int[] array) {
        File a = new File(file);
        if (a.exists()) {
            try {
                Scanner in = new Scanner(a);
                String s = in.next().substring(1);
                int t = Integer.parseInt(s);
                ArrayList<Integer> data = new ArrayList<>();
                while (in.hasNext()) {
                    data.add(Integer.parseInt(in.next()));
                }
                array = data.stream().mapToInt(i -> i).toArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Implementation of insertion sort.
     * @return the sorted array of data
     * @param input
     */
    public int[] insertionSort(int[] input) {
        int i = 1;
        while (i < input.length) {
            int j = i;
            while (j > 0 && input[j - 1] > input[j]) {
                int temp = input[j];
                input[j] = input[j-1];
                input[j-1] = temp;
                j--;
            }
            i++;
        }
        return input;
    }

    /**
     * Implementation of selection sort.
     * @return the sorted array of data
     */
    public int[] selectionSort(int[] input, int stop) {
        int x = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (x > stop)
                break;
            x++;
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min])
                    min = j;
            }
            if (min != i) {
                int temp = input[i];
                input[i] = input[min];
                input[min] = temp;
            }
        }
        return input;
    }

    /**
     * Implementation of selection sort.
     * @return the sorted array of data
     */
    public int[] selectionSort(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[min])
                    min = j;
            }
            if (min != i) {
                int temp = input[i];
                input[i] = input[min];
                input[min] = temp;
            }
        }
        return input;
    }

    /**
     * Implementation of bubble sort
     * @return the sorted array of data
     * @param input
     */
    public int[] bubbleSort(int[] input) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < input.length; i++) {
                if (input[i - 1] > input[i]) {
                    int temp = input[i];
                    input[i] = input[i-1];
                    input[i-1] = temp;
                    swap = true;
                }
            }
        }
        return input;
    }

    /**
     * Implementation of merge sort
     * @return the sorted array of data
     * @param input
     */

    public int[] mergeSort(int[] input) {
        if (input.length <= 1)
            return input;

        int[] left;
        int[] right;
        left = Arrays.copyOfRange(input, 0, input.length / 2);
        right = Arrays.copyOfRange(input, input.length / 2, input.length);


        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                result[i + j] = right[j];
                j++;
            } else {
                result[i + j] = left[i];
                i++;
            }
        }
        while (i < left.length) {
            result[i + j] = left[i];
            i++;
        }
        while (j < right.length) {
            result[i + j] = right[j];
            j++;
        }
        return result;
    }

    /**
     * Method for swapping elements at an index.
     *
     * @param index1 index of first element
     * @param index2 index of second element
     */
    private void swapReferences(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Recursive quick sort method.
     *
     * @param low left-most index of sub-array
     * @param high right-most index of sub-array
     */
    public void quickSort(int[] array, int low, int high) {
        // Calculate number of elements
        int numElements = high - low + 1;

        if (numElements == 1) {        // If only 1 element
            // Do nothing since ordered with itself
        } else if (numElements == 2) { // If only 2 elements
            if (array[high] < array[low]) {
                swapReferences(array, low, high);
            }
        } else if (numElements == 3) { // If only 3 elements

            // Get middle index
            int middle = (low + high) / 2;

            // Sort the elements at low, middle, high indices
            if (array[middle] < array[low]) {
                swapReferences(array, low, middle);
            }
            if (array[high] < array[low]) {
                swapReferences(array, low, high);
            }
            if (array[high] < array[middle]) {
                swapReferences(array, middle, high);
            }
        } else {

            // Get middle index
            int middle = (low + high) / 2;

            // Sort the elements at low, middle, high indices
            if (array[middle] < array[low]) {
                swapReferences(array, low, middle);
            }
            if (array[high] < array[low]) {
                swapReferences(array, low, high);
            }
            if (array[high] < array[middle]) {
                swapReferences(array, middle, high);
            }

            // Move pivot to left of element at high index
            swapReferences(array, middle, high - 1);

            // Temporary storage of pivot element for comparing
            int pivot = array[high - 1];

            // Partition
            int i, j;
            for (i = low, j = high - 1; ; ) {

                // Start incrementing from left until find element larger
                while (array[++i] < pivot) {
                    ; // Just keep comparing
                }

                // Start decrementing from right until find element smaller
                while (pivot < array[--j]) {
                    ; // Just keep comparing
                }

                // Stop if i and j cross
                if (i >= j) {
                    break;
                }

                // Swap elements if i and j stop without crossing
                swapReferences(array, i, j);
            }

            // Put pivot in correct location, which is where i is at the time i and j cross
            swapReferences(array, i, high - 1);

            // Repeat on either side of the pivot
            quickSort(array, low, i - 1);
            quickSort(array, i + 1, high);
        }
    }
}
