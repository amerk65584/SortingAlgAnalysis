package controller;

import model.DataTypes;
import model.SortingAlgorithms;
import view.SortingPanel;

/**
 * Controller for sorting algorithm visualization.
 *
 * @author Alex Merk
 * @author Nicole Kauer
 */
public class Controller {

    /* The type of data. */
    private DataTypes myType;

    /* The sorting algorithm to use. */
    private SortingAlgorithms mySort;

    /* The sorting panel that will be visualizing the data.
     * Need to re-register as listener for data.
     */
    private SortingPanel myPanel;

    /**
     * Constructor.
     *
     * @param thePanel the panel listening for data changes
     */
    public Controller(final SortingPanel thePanel) {

        super();
        myPanel = thePanel;

        // Just initialize to defaults
        mySort = SortingAlgorithms.SELECTION;
    }

    /**
     * Set the type of data to use.
     *
     * @param theType the data type
     */
    public void setDataType(final DataTypes theType){
        myPanel.simpleData(theType);
        myPanel.repaint();
    }

    /**
     * Set the sorting algorithm to use.
     *
     * @param theSortAlg the sorting algorithm
     */
    public void setSortAlgorithm(final SortingAlgorithms theSortAlg) {
        mySort = theSortAlg;
    }

    /**
     * Start sorting and replay.
     */
    public void startSort(){

        switch (mySort) {
            case SELECTION:
                myPanel.selectionSort();
                break;
            case INSERTION:
                myPanel.insertionSort();
                break;
            case BUBBLE:
                myPanel.bubbleSort();
                break;
            case MERGESORT:
                myPanel.startMergeSort();
                break;
            case QUICKSORT:
                myPanel.startQuickSort();
                break;
            default:
                break;
        }
    }

    /**
     * Stop sorting replay.
     */
    public void stopSort() {
        myPanel.stopReplay();
    }
}
