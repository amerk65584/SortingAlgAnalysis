package view;

import controller.Controller;
import model.DataTypes;
import model.SortingAlgorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.InputEvent;

/*
 * view.MenuBar class for sorting GUI.
 * @author Alex Merk
 * @author Nicole Kauer
 */
public class MenuBar extends JMenuBar {
    /* The frame. */
    private final SortingFrame myFrame;

    /* The controller. */
    private final Controller myController;

    /**
     * Constructor.
     *
     * @param theController the controller
     * @param theFrame the frame that has the menu bar
     */
    public MenuBar(final Controller theController, final SortingFrame theFrame)
    {
        // Calls JMenuBar default constructor
        super();

        // Set the controller and frame
        myController = theController;
        myFrame = theFrame;

        // Setup and add the view.MenuBar elements
        setup();
    }

    /* Setup methods */

    /**
     * Setup and add the Tetris view.MenuBar elements.
     */
    private void setup()
    {
        this.add(createMainMenu());
        this.add(createDataMenu());
        this.add(createSortMenu());
    }

    //--------------------------------------------------------------------------------------//

    /**
     * Creates the Main menu for the menu bar.
     *
     * @return the Main menu
     */
    private JMenu createMainMenu()
    {
        final JMenu myMainMenu = new JMenu("Main Menu");
        final JMenuItem myStartSortItem = createStartSortItem();
        final JMenuItem myStopSortItem = createStopSortItem();
        final JMenuItem exitItem = createExitItem();

        myMainMenu.add(myStartSortItem);
        myMainMenu.add(myStopSortItem);
        myMainMenu.addSeparator();
        myMainMenu.add(exitItem);

        return myMainMenu;
    }

    /**
     * Creates the start sort item.
     *
     * @return the start sort item
     */
    private JMenuItem createStartSortItem()
    {
        final JMenuItem startSortItem = new JMenuItem("Start Sorting");

        /*
         * Listener class for starting a new game.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class StartSortListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.startSort();
            }
        }

        startSortItem.addActionListener(new StartSortListener());
        startSortItem.setMnemonic(KeyEvent.VK_S);
        final KeyStroke startSortKey = KeyStroke.getKeyStroke(KeyEvent.VK_S,
                InputEvent.CTRL_MASK);
        startSortItem.setAccelerator(startSortKey);

        return startSortItem;
    }

    /**
     * Creates the stop sort item.
     *
     * @return the stop sort item
     */
    private JMenuItem createStopSortItem()
    {
        final JMenuItem stopSortItem = new JMenuItem("Stop Sorting");

        /*
         * Listener class for starting a new game.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class StopSortListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.stopSort();
            }
        }

        stopSortItem.addActionListener(new StopSortListener());
        stopSortItem.setMnemonic(KeyEvent.VK_P);
        final KeyStroke stopSortKey = KeyStroke.getKeyStroke(KeyEvent.VK_P,
                InputEvent.CTRL_MASK);
        stopSortItem.setAccelerator(stopSortKey);

        return stopSortItem;
    }

    /**
     * Creates the exit program item.
     *
     * @return the exit item
     */
    private JMenuItem createExitItem()
    {
        final JMenuItem exitItem = new JMenuItem("Exit");

        /*
         * Listener to exit the program from menu item.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class ExitListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            }
        }

        exitItem.addActionListener(new ExitListener());
        exitItem.setMnemonic(KeyEvent.VK_X);
        final KeyStroke exitKey = KeyStroke.getKeyStroke(KeyEvent.VK_X,
                InputEvent.CTRL_MASK);
        exitItem.setAccelerator(exitKey);

        return exitItem;
    }

    //--------------------------------------------------------------------------------------//

    /**
     * Creates the Data Type menu for the menu bar.
     *
     * @return the Data Type menu
     */
    private JMenu createDataMenu()
    {
        /* Action listener classes for buttons. */

        /*
         * Listener to choose reverse sorted data.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class RevDataListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setDataType(DataTypes.REVERSE);
            }
        }

        /*
         * Listener to choose random sorted data.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class RandDataListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setDataType(DataTypes.RANDOM);
            }
        }

        /* Make menu */
        final JMenu dataMenu = new JMenu("Data Type");

        final ButtonGroup buttonGroup = new ButtonGroup();

        // Reverse data
        final JRadioButtonMenuItem revDataButton = new JRadioButtonMenuItem("Reverse Sorted Data");
        revDataButton.addActionListener(new RevDataListener());
        buttonGroup.add(revDataButton);
        revDataButton.setSelected(true);
        dataMenu.add(revDataButton);

        // Random data
        final JRadioButtonMenuItem randDataButton = new JRadioButtonMenuItem("Random Data");
        randDataButton.addActionListener(new RandDataListener());
        buttonGroup.add(randDataButton);
        dataMenu.add(randDataButton);

        return dataMenu;
    }

    //--------------------------------------------------------------------------------------//

    /**
     * Creates the sorting algorithm menu for the menu bar.
     *
     * @return the sorting algorithm menu
     */
    private JMenu createSortMenu()
    {
        /* Action listener classes for buttons. */

        /*
         * Listener to choose quicksort algorithm.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class QuicksortListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setSortAlgorithm(SortingAlgorithms.QUICKSORT);
            }
        }

        /*
         * Listener to choose mergesort algorithm.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class MergesortListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setSortAlgorithm(SortingAlgorithms.MERGESORT);
            }
        }

        /*
         * Listener to choose selection sort algorithm.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class SelectionListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setSortAlgorithm(SortingAlgorithms.SELECTION);
            }
        }

        /*
         * Listener to choose insertion sort algorithm.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class InsertionListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setSortAlgorithm(SortingAlgorithms.INSERTION);
            }
        }

        /*
         * Listener to choose bubble sort algorithm.
         *
         * @author Alex Merk
         * @author Nicole Kauer
         */
        class BubbleListener implements ActionListener
        {
            @Override
            public void actionPerformed(final ActionEvent theArg)
            {
                myController.setSortAlgorithm(SortingAlgorithms.BUBBLE);
            }
        }

        /* Make menu */
        final JMenu sortMenu = new JMenu("Sorting Algorithm");

        final ButtonGroup buttonGroup = new ButtonGroup();

        // Insertion Sort
        final JRadioButtonMenuItem insertionButton = new JRadioButtonMenuItem("Insertion Sort");
        insertionButton.addActionListener(new InsertionListener());
        buttonGroup.add(insertionButton);
        sortMenu.add(insertionButton);

        // Selection sort
        final JRadioButtonMenuItem selectionButton = new JRadioButtonMenuItem("Selection Sort");
        selectionButton.addActionListener(new SelectionListener());
        buttonGroup.add(selectionButton);
        selectionButton.setSelected(true);
        sortMenu.add(selectionButton);

        // Bubble sort
        final JRadioButtonMenuItem bubbleButton = new JRadioButtonMenuItem("Bubble Sort");
        bubbleButton.addActionListener(new BubbleListener());
        buttonGroup.add(bubbleButton);
        sortMenu.add(bubbleButton);

        // Quicksort
        final JRadioButtonMenuItem quicksortButton = new JRadioButtonMenuItem("Quicksort");
        quicksortButton.addActionListener(new QuicksortListener());
        buttonGroup.add(quicksortButton);
        sortMenu.add(quicksortButton);

        // Mergesort
        final JRadioButtonMenuItem mergesortButton = new JRadioButtonMenuItem("Mergesort");
        mergesortButton.addActionListener(new MergesortListener());
        buttonGroup.add(mergesortButton);
        sortMenu.add(mergesortButton);

        return sortMenu;
    }
}
