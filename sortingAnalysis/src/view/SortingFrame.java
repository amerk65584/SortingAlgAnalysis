package view;

import model.Data;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Main sorting GUI frame.
 * @author Alex Merk
 * @author Nicole Kauer
 */
public final class SortingFrame extends JFrame {
    /* model.Data to sort. */
    protected Data myData;

    /* The controller. */
    protected Controller myController;

    /* The menu bar. */
    protected MenuBar myMenuBar;

    /* The main panel. */
    private SortingPanel myPanel;

    /* Preferred size. */
    private static final Dimension PREFERRED_SIZE_STANDARD = new Dimension(600, 650);

    /* Minimum size. */
    private static final Dimension MINIMUM_SIZE = new Dimension(425, 380);

    /* Rigid area dimensions for layout padding. */
    private static final Dimension RIGID_AREA_SIZE = new Dimension(240, 20);

    /* Rigid aarea dimensions for layout padding on east side of frame. */
    private static final Dimension EAST_RIGID_SPACING = new Dimension(20, 240);

    /*
     * Constructor.
     */
    public SortingFrame()
    {
        super(); // Call JFrame constructor
        setup(); // Setup the window
    }

    /* Setup methods */

    /*
     * Setup the GUI elements and add to the frame.
     */
    private void setup()
    {
        // Create panel and add to frame
        myPanel = new SortingPanel();
        add(myPanel, BorderLayout.CENTER);

        // Need the controller
        myController = new Controller(myPanel);

        // Create menu bar and set into frame
        myMenuBar = new MenuBar(myController, this);
        setJMenuBar(myMenuBar);


        /* Window settings */

        setTitle("TCSS 598 - Sorting Algorithm Visualization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(PREFERRED_SIZE_STANDARD);
        setResizable(false);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}

