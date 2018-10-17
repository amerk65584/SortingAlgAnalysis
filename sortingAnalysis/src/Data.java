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
        testSorts();
    }

    private void testSorts() {
        data = new int[20];
        for (int i = 0; i < 20; i++) {
            data[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("quick: " + Arrays.toString(data));

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

    private int[] mergeSort(int[] a) {
        if (a.length <= 1)
            return a;

        int[] left = new int[a.length / 2];
        int[] right = new int[a.length - a.length / 2];
        left = Arrays.copyOfRange(a, 0, a.length / 2);
        right = Arrays.copyOfRange(a, a.length / 2, a.length);
//        for (int i = 0; i < a.length; i++) {
//            if (i < a.length / 2)
//                left[i] = a[i];
//            else
//                right[i - a.length / 2] = a[i];
//        }

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
    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
        System.out.println(Arrays.toString(array));
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low;

        for (int i = low + 1; i < high; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                left++;
            }
        }
        int temp = array[left];
        array[left] = array[low];
        array[low] = temp;

        return left;
    }
}
