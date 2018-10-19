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
    private double[] original;

    /**
     * Copy arrays for semi-sorting
     */
    protected double[] copyOne;
    protected double[] copyTwo;
    protected double[] copyThree;
    protected double[] copyFour;
    protected double[] copyFive;


    /**
     *Arrays to hold copies of the original data.
     * All 5 arrays will be filled with either:
     *  data sorted in reverse order
     *  sin(i) + 1
     *  real data 1
     *  real data 2
     * dataOne will be 20% size of the original array.
     * dataTwo will be 40% size of the original array.
     * dataThree will be 60% size of the original array.
     * dataFour will be 80% size of the original array.
     * dataFive will be 100% size of the original array.
     *
     */
    protected double[] dataOne;
    protected double[] dataTwo;
    protected double[] dataThree;
    protected double[] dataFour;
    protected double[] dataFive;
    /**
     * Makes calls to construct and fill data sets with values and perform the experiments.
     */
    public Data(int choice) {
        super();
        switch (choice) {
            case 1:
                original = new double[100000];
                for (int i = 0; i < original.length; i++) {
                    original[i] = original.length - i;
                }
                break;
            case 2:
                original = new double[100000];
                for (int i = 0; i < original.length; i++) {
                    original[i] = Math.sin(i) + 1;
                }
                break;
            case 3:
                readFileOne("Data/USCensusWA_wage_100k.csv");
                break;
            case 4:
                //read files here
                break;
            default:
                break;
        }
    }

    public void genRevSynth() {
        dataOne = new double[(int) (original.length * .2)];
        dataTwo = new double[(int) (original.length * .4)];
        dataThree = new double[(int) (original.length * .6)];
        dataFour = new double[(int) (original.length * .8)];
        dataFive = new double[original.length];

        for (int i = 0; i < original.length; i++) {
            if (i < dataOne.length) {
                dataOne[i] = dataOne.length - i;
                dataTwo[i] = dataTwo.length - i;
                dataThree[i] = dataThree.length - i;
                dataFour[i] = dataFour.length - i;
                dataFive[i] = dataFive.length - i;
            }
            else if (i < dataTwo.length) {
                dataTwo[i] = dataTwo.length - i;
                dataThree[i] = dataThree.length - i;
                dataFour[i] = dataFour.length - i;
                dataFive[i] = dataFive.length - i;
            }
            else if (i < dataThree.length) {
                dataThree[i] = dataThree.length - i;
                dataFour[i] = dataFour.length - i;
                dataFive[i] = dataFive.length - i;
            }
            else if (i < dataFour.length) {
                dataFour[i] = dataFour.length - i;
                dataFive[i] = dataFive.length - i;
            } else {
                dataFive[i] = dataFive.length - i;
            }
        }
    }

    public void genSin() {
        dataOne = new double[(int) (original.length * .2)];
        dataTwo = new double[(int) (original.length * .4)];
        dataThree = new double[(int) (original.length * .6)];
        dataFour = new double[(int) (original.length * .8)];
        dataFive = new double[original.length];

        for (int i = 0; i < original.length; i++) {
            if (i < dataOne.length) {
                dataOne[i] = Math.sin(i) + 1;
                dataTwo[i] = Math.sin(i) + 1;
                dataThree[i] = Math.sin(i) + 1;
                dataFour[i] = Math.sin(i) + 1;
                dataFive[i] = Math.sin(i) + 1;
            }
            else if (i < dataTwo.length) {
                dataTwo[i] = Math.sin(i) + 1;
                dataThree[i] = Math.sin(i) + 1;
                dataFour[i] = Math.sin(i) + 1;
                dataFive[i] = Math.sin(i) + 1;
            }
            else if (i < dataThree.length) {
                dataThree[i] = Math.sin(i) + 1;
                dataFour[i] = Math.sin(i) + 1;
                dataFive[i] = Math.sin(i) + 1;
            }
            else if (i < dataFour.length) {
                dataFour[i] = Math.sin(i) + 1;
                dataFive[i] = Math.sin(i) + 1;
            } else {
                dataFive[i] = Math.sin(i) + 1;
            }
        }
    }

    public void readFileOne(String file) {
        File a = new File(file);
        if (a.exists()) {
            try {
                Scanner in = new Scanner(a);
                String s = in.next().substring(1);
                double t = Integer.parseInt(s);
                ArrayList<Double> data = new ArrayList<>();
                while (in.hasNext()) {
                    data.add((double) Integer.parseInt(in.next()));
                }
                original = data.stream().mapToDouble(i -> i).toArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        dataOne = new double[(int) (original.length * .2)];
        dataTwo = new double[(int) (original.length * .4)];
        dataThree = new double[(int) (original.length * .6)];
        dataFour = new double[(int) (original.length * .8)];
        dataFive = new double[original.length];

        for (int i = 0; i < original.length; i++) {
            if (i < dataOne.length) {
                dataOne[i] = original[i];
                dataTwo[i] = original[i];
                dataThree[i] = original[i];
                dataFour[i] = original[i];
                dataFive[i] = original[i];
            }
            else if (i < dataTwo.length) {
                dataTwo[i] = original[i];
                dataThree[i] = original[i];
                dataFour[i] = original[i];
                dataFive[i] = original[i];
            }
            else if (i < dataThree.length) {
                dataThree[i] = original[i];
                dataFour[i] = original[i];
                dataFive[i] = original[i];
            }
            else if (i < dataFour.length) {
                dataFour[i] = original[i];
                dataFive[i] = original[i];
            } else {
                dataFive[i] = original[i];
            }
        }
    }

    public void semiSort() {
        copyOne = Arrays.copyOfRange(original, 0, original.length);
        copyTwo = Arrays.copyOfRange(original, 0, original.length);
        copyThree = Arrays.copyOfRange(original, 0, original.length);
        copyFour = Arrays.copyOfRange(original, 0, original.length);
        copyFive = Arrays.copyOfRange(original, 0, original.length);

        selectionSort(copyOne, (int) (copyOne.length * .2));
        selectionSort(copyTwo, (int) (copyTwo.length * .4));
        selectionSort(copyThree, (int) (copyThree.length * .6));
        selectionSort(copyFour, (int) (copyFour.length * .8));
    }

    public void print() {
        System.out.println(Arrays.toString(dataOne));
        System.out.println(Arrays.toString(dataTwo));
        System.out.println(Arrays.toString(dataThree));
        System.out.println(Arrays.toString(dataFour));
        System.out.println(Arrays.toString(dataFive));
    }
    /**
     * Implementation of insertion sort.
     * @return the sorted array of data
     */
    public double[] insertionSort(double[] input) {
        int i = 1;
        while (i < input.length) {
            int j = i;
            while (j > 0 && input[j - 1] > input[j]) {
                double temp = input[j];
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
    public double[] selectionSort(double[] input, int stop) {
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
                double temp = input[i];
                input[i] = input[min];
                input[min] = temp;
            }
        }
        return input;
    }

    /**
     * Implementation of bubble sort
     * @return the sorted array of data
     */
    public double[] bubbleSort(double[] input) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < input.length; i++) {
                if (input[i - 1] > input[i]) {
                    double temp = input[i];
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
     */

    private double[] mergeSort(double[] input) {
        if (input.length <= 1)
            return input;

        double[] left;
        double[] right;
        left = Arrays.copyOfRange(input, 0, input.length / 2);
        right = Arrays.copyOfRange(input, input.length / 2, input.length);


        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
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
            quickSort(array, low, pivot);
            quickSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low;

        for (int i = low + 1; i < high; i++) {
            if (array[i] < pivot) {
                left++;
                int temp = array[i];
                array[i] = array[left];
                array[left] = temp;
            }
        }

        int temp = array[left];
        array[left] = array[low];
        array[low] = temp;

        return left;
    }
}
