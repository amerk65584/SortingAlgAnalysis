import java.io.File;
import java.util.Arrays;

/**
 * Main class containing our sorting algorithms.
 * @author Alex Merk.
 * @author Nicole Kauer.
 */
public class Data {

    /**
     * Array to hold all of the data sets.
     */
    private int data[];

    /**
     * Makes calls to construct and fill data sets with values and perform the experiments.
     */
    public Data() {
        super();
    }

    /**
     * Fills the array with the real world data set.
     */
    public void buildRealData(final File data1) {
        data = new int[0];
    }

    /**
     * Fills the array with synthetic data set.
     */
    public void buildSyntheticData() {
        data = new int[0];
    }

    /**
     * Implementation of insertion sort.
     * @return the sorted array of data
     */
    public int[] insertionSort() {
        int i = 1;
        while (i < data.length) {
            int j = i;
            while (j > 0 && data[j - 1] > data[j]) {
                int temp = data[j];
                data[j] = data[j-1];
                data[j-1] = temp;
                j--;
            }
            i++;
        }
        return data;
    }

    /**
     * Implementation of selection sort.
     * @return the sorted array of data
     */
    public int[] selectionSort() {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min])
                    min = j;
            }
            if (min != i) {
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
        return data;
    }

    /**
     * Implementation of bubble sort
     * @return the sorted array of data
     */
    public int[] bubbleSort() {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < data.length; i++) {
                if (data[i - 1] > data[i]) {
                    int temp = data[i];
                    data[i] = data[i-1];
                    data[i-1] = temp;
                    swap = true;
                }
            }
        }
        return data;
    }

    /**
     * Implementation of merge sort
     * @return the sorted array of data
     */
    public int[] mergeSortStart() {
        return mergeSort(data);
    }

    private int[] mergeSort(int[] a) {
        if (a.length == 1)
            return a;
        int[] left = Arrays.copyOfRange(data, 0, data.length / 2);
        int[] right = Arrays.copyOfRange(data, data.length / 2 + 1, data.length);

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
     * Implementation of quick sort
     * @return the sorted array of data
     */
    public int[] quickSort() {

    }
}