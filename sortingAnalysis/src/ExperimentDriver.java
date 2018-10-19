import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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

    /**
     * Just main.
     */
    public static void main(String[] args) {
        runTime_dataSize();
        runTime_degSort();
        memUse_dataSize();
        memUse_degSort();
    }

    private static void testFiles() {

    }
    private static void runTime_dataSize() {
        Data data = new Data(1);
        data.genRevSynth();
        //track times here

        data = new Data(2);
        data.genSin();
        //track times here

        data = new Data(3);
        //track times here

        data = new Data(4);
        //track times here
    }

    private static void runTime_degSort() {
        Data data = new Data(1);
        data.semiSort();
        //track times here

        data = new Data(2);
        data.semiSort();
        //track times here

        data = new Data(3);
        //track times here

        data = new Data(4);
        //track times here
    }

    private static void memUse_dataSize() {
        Data data = new Data(1);
        data.genRevSynth();
        //track mem here

        data = new Data(2);
        data.genSin();
        //track mem here

        data = new Data(3);
        //track mem here

        data = new Data(4);
        //track mem here
    }

    private static void memUse_degSort() {
        Data data = new Data(1);
        data.semiSort();
        //track mem here

        data = new Data(2);
        data.semiSort();
        //track mem here

        data = new Data(3);
        //track mem here

        data = new Data(4);
        //track mem here
    }
}
