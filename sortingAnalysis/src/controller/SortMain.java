package controller;/*
 * Launches GUI for sorting visualization.
 * @author Alex Merk
 * @author Nicole Kauer
 */

import view.SortingFrame;

import java.awt.EventQueue;

public final class SortMain {

    /*
     * Private constructor to avoid instantiation.
     */
    private SortMain(){
        // Do nothing.
    }

    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
          @Override public void run() {
              new SortingFrame();
          }
        });
    }
}
