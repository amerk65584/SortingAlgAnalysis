package view;

import model.DataTypes;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

import static model.DataTypes.REVERSE;

public class SortingPanel extends JPanel implements ActionListener {

    /* Related to data */

    /* Maximum array size.*/
    private static final int NUM_POINTS = 100;

    /* Original array for data.*/
    private int[] original;

    /* Data steps while sorting. */
    private List<int[]> myDataSteps;

    /* Data step iterator. */
    private Iterator<int[]> myIterator;

    /* Related to panel */

    /* Graphics block. */
    protected static final Rectangle2D BLOCK = new Rectangle2D.Double();

    /* Panel width. */
    private static int PANEL_WIDTH = 500;

    /* Panel height. */
    private static int PANEL_HEIGHT = 500;

    /* Max value of data point. */
    private static int MAXVALUE = 100;

    /* Width of block. */
    private static int BLOCK_WIDTH = 5;

    /* Height multiple for block. */
    private static int BLOCK_HEIGHT_MULT = 5;

    /* Height padding. */
    private static int HEIGHT_PAD = 50;

    /* Width padding. */
    private static int WIDTH_PAD = 50;

    /* Maximum color value. */
    private static int MAX_COLOR_VAL = 255;

    /* Color. */
    private Color myColor;

    /* Related to timing */

    /* Wait timer to let the visualization print to screen. */
    private static final int TIMEOUT = 10;

    /* Timer for waiting. */
    private Timer myTimer;

    /* Boolean check. */
    private boolean isInitialPaint;

    /* Panel methods */

    /**
     * Panel constructor.
     */
    public SortingPanel()
    {
        // Calls JPanel default constructor
        super();
        myColor = Color.BLACK;
        myDataSteps = new ArrayList<int[]>();
        myTimer = new Timer(TIMEOUT, this);
        simpleData(REVERSE);
        setSize(new Dimension(PANEL_WIDTH,
                PANEL_HEIGHT));
        setBackground(Color.LIGHT_GRAY);
    }

    /**
     * Paints panel.
     *
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics)
    {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int[] comp = new int[2];
        for (int i = 0; i < original.length; i++) {
            // setFrame(upper left x coord, upper left y coord, width, height)

            // Data block
            BLOCK.setFrame(BLOCK_WIDTH * i + WIDTH_PAD, PANEL_HEIGHT - (BLOCK_HEIGHT_MULT * original[i] - HEIGHT_PAD),
                    BLOCK_WIDTH, BLOCK_HEIGHT_MULT * original[i]);

            int value = MAX_COLOR_VAL - (MAX_COLOR_VAL*original[i])/MAXVALUE;
            g.setPaint(new Color(value,0,MAX_COLOR_VAL));
            g.fill(BLOCK);
            // Outline the rectangle
            g.setPaint(Color.DARK_GRAY);
            g.draw(BLOCK);
        }

    }

    /* Timing */

    /**
     * Starts showing the sorting process.
     */
    public void replaySort()
    {
        if (myDataSteps == null || myDataSteps.isEmpty()){
            //Do nothing
        } else {
            myIterator = myDataSteps.iterator();
            myTimer.setDelay(TIMEOUT);
            myTimer.start();
        }
    }

    /**
     * Stops the sorting replay.
     */
    public void stopReplay(){
        myTimer.stop();
        myDataSteps.clear();
    }

    /**
     * Timer action for replaying the game.
     *
     * @param theArg ignored
     */
    @Override
    public void actionPerformed(final ActionEvent theArg)
    {
        if (myIterator.hasNext())
        {
            original = myIterator.next();
            repaint();
        } else {
            myTimer.stop();
        }

    }

    /* Data creation and sorting method selection */

    /**
     * Makes calls to construct and fill data set with values.
     *
     * @param theType the data type
     */
    public void simpleData(DataTypes theType) {

        switch (theType) {
            case REVERSE:
                if (!myDataSteps.isEmpty()){
                    myDataSteps.clear();
                }
                original = new int[NUM_POINTS];
                for (int i = 0; i < original.length; i++) {
                    original[i] = original.length - i;
                }
                repaint();
                break;
            case RANDOM:
                if (!myDataSteps.isEmpty()){
                    myDataSteps.clear();
                }
                original = new int[NUM_POINTS];
                Random rand = new Random();
                for (int i = 0; i < original.length; i++) {
                    original[i] = rand.nextInt(MAXVALUE);
                }
                repaint();
                break;
            default:
                break;
        }
    }

    /**
     * Implementation of insertion sort.
     */
    public void insertionSort() {
        myDataSteps.add(original.clone());
        int i = 1;
        while (i < original.length) {
            int j = i;
            while (j > 0 && original[j - 1] > original[j]) {
                int temp = original[j];
                original[j] = original[j-1];
                original[j-1] = temp;
                j--;
                myDataSteps.add(original.clone());
            }
            //myDataSteps.add(original.clone()); //
            i++;
        }
        replaySort();
    }

    /**
     * Implementation of selection sort.
     */
    public void selectionSort() {
        myDataSteps.add(original.clone());
        for (int i = 0; i < original.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < original.length; j++) {
                myDataSteps.add(original.clone());
                if (original[j] < original[min])
                    min = j;
            }
            if (min != i) {
                int temp = original[i];
                original[i] = original[min];
                original[min] = temp;
            }
        }
        replaySort();
    }

    /**
     * Implementation of bubble sort
     */
    public void bubbleSort() {
        myDataSteps.add(original.clone());
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < original.length; i++) {
                if (original[i - 1] > original[i]) {
                    int temp = original[i];
                    original[i] = original[i-1];
                    original[i-1] = temp;
                    swap = true;
                    //myDataSteps.add(original.clone());
                }
                myDataSteps.add(original.clone());
            }
        }
        replaySort();
    }

    /**
     * Method for swapping elements at an index.
     *
     * @param index1 index of first element
     * @param index2 index of second element
     */
    private void swapReferences(int index1, int index2) {
        int temp = original[index1];
        original[index1] = original[index2];
        original[index2] = temp;
        myDataSteps.add(original.clone());
    }

    /**
     * Method to start quicksort.
     */
    public void startQuickSort(){
        quickSort(0,original.length - 1);
    }

    /**
     * Recursive quick sort method.
     *
     * @param low left-most index of sub-array
     * @param high right-most index of sub-array
     */
    public void quickSort(int low, int high) {
        myDataSteps.add(original.clone());
        // Calculate number of elements
        int numElements = high - low + 1;

        if (numElements == 1) {        // If only 1 element
            // Do nothing since ordered with itself
        } else if (numElements == 2) { // If only 2 elements
            if (original[high] < original[low]) {
                swapReferences(low, high);
            }
        } else if (numElements == 3) { // If only 3 elements

            // Get middle index
            int middle = (low + high) / 2;

            // Sort the elements at low, middle, high indices
            if (original[middle] < original[low]) {
                swapReferences(low, middle);
            }
            if (original[high] < original[low]) {
                swapReferences(low, high);
            }
            if (original[high] < original[middle]) {
                swapReferences(middle, high);
            }
        } else {

            // Get middle index
            int middle = (low + high) / 2;

            // Sort the elements at low, middle, high indices
            if (original[middle] < original[low]) {
                swapReferences(low, middle);
            }
            if (original[high] < original[low]) {
                swapReferences(low, high);
            }
            if (original[high] < original[middle]) {
                swapReferences(middle, high);
            }

            // Move pivot to left of element at high index
            swapReferences(middle, high - 1);

            // Temporary storage of pivot element for comparing
            int pivot = original[high - 1];

            // Partition
            int i, j;
            for (i = low, j = high - 1; ; ) {

                // Start incrementing from left until find element larger
                while (original[++i] < pivot) {
                    ; // Just keep comparing
                }

                // Start decrementing from right until find element smaller
                while (pivot < original[--j]) {
                    ; // Just keep comparing
                }

                // Stop if i and j cross
                if (i >= j) {
                    break;
                }

                // Swap elements if i and j stop without crossing
                swapReferences(i, j);
            }

            // Put pivot in correct location, which is where i is at the time i and j cross
            swapReferences(i, high - 1);

            // Repeat on either side of the pivot
            quickSort(low, i - 1);
            quickSort(i + 1, high);
        }
        replaySort();
    }

    /* In-place Mergesort */

    /**
     * Method to start Mergesort.
     * Pseudocode for this algorithm from Elementary Algorithms by Larry LIU Xinyu.
     */
    public void startMergeSort(){
        mergeSort(0, original.length );
        myDataSteps.add(original.clone());
        replaySort();
    }

    /**
     * Mergesort in place, part 1.
     *
     * @param lower the lower bound index
     * @param upper the upper bound index
     */
    private void mergeSort(int lower, int upper){
        if (upper - lower > 1) {
            int mid = lower + (upper - lower)/2;
            int work = lower + upper - mid;
            mergeSortAlso(lower, mid, work);
            while (work - lower > 1){
                int nUpper = work;
                work = lower + (nUpper - lower + 1)/2;
                mergeSortAlso(work, nUpper, lower);
                merge(lower, (lower + nUpper - work), nUpper, upper, work);
            }
            for (int i = work; i > lower; --i){
                int j = i;
                while ((j < upper) && original[j] < original[j-1]){
                    int temp = original[j];
                    original[j] = original[j-1];
                    original[j-1] = temp;
                    j++;
                }
            }
        }
    }

    /**
     * Mergesort in place, part 2.
     *
     * @param lower the lower bound index
     * @param upper the upper bound index
     * @param work the starting index of the work area
     */
    private void mergeSortAlso(int lower, int upper, int work){
        if (upper - lower > 0){
            int mid = lower + (upper - lower)/2;
            mergeSort(lower, mid);
            mergeSort(mid, upper);
            merge(lower, mid, mid, upper, work);
        } else {
            while (lower <= upper){
                int temp = original[lower];
                original[lower] = original[work];
                original[work] = temp;
                lower++;
                work++;
            }
        }
    }

    /**
     * Merge part of mergesort.
     *
     * @param leftLower the lower left bound index
     * @param rightLower the lower right bound index
     * @param leftUpper the upper left bound index
     * @param rightUpper the upper right bound index
     * @param work the starting index of the work area
     */
    private void merge(int leftLower, int rightLower, int leftUpper, int rightUpper, int work){
        while ((leftLower < rightLower) && (leftUpper < rightUpper)) {
            if (original[leftLower] < original[leftUpper]){
                int temp = original[leftLower];
                original[leftLower] = original[work];
                original[work] = temp;
                leftLower++;
                myDataSteps.add(this.original.clone());
            } else {
                int temp = original[leftUpper];
                original[leftUpper] = original[work];
                original[work] = temp;
                leftUpper++;
                myDataSteps.add(this.original.clone());
            }
            work++;
        }
        while (leftLower < rightLower) {
            int temp = original[leftLower];
            original[leftLower] = original[work];
            original[work] = temp;
            leftLower++;
            work++;
            myDataSteps.add(this.original.clone());
        }
        while (leftUpper < rightUpper) {
            int temp = original[leftUpper];
            original[leftUpper] = original[work];
            original[work] = temp;
            leftUpper++;
            work++;
            myDataSteps.add(this.original.clone());
        }
    }
}
