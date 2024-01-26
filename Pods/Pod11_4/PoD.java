package Pods.Pod11_4;

/**
 * CSCI 1105
 * @author ASiegel, YourName
 */

import java.util.*;

public class PoD {
    // PLEASE START YOUR CODE HERE
    // *********************************************************

    /**
     * METHOD: drawLine
     * Prints a string of the requested number of lines (hyphens: "-")
     * (i.e. 1 -> "-", 2 -> "--", 3 -> "---", 4 -> "----", etc.)
     * @param lineLength  integer number of underscores expected
     * @return
     */

    public static void drawLine(int lineLength) {
        // WRITE YOUR CODE HERE
        System.out.println("-".repeat(lineLength));
    }

    /**
     * METHOD: drawRulerLines
     * 1. Recursively draws the ruler lines above (1 shorter than centre line)
     * 2. Draws the centre line
     * 3. Recursively draws the ruler lines below (1 shorter than centre line)
     * @param lineLength  integer length of centre line
     * @return void
     */
    public static void drawRulerLines(int lineLength) {
// WRITE YOUR CODE HERE
        if(lineLength > 0) {
            drawRulerLines(lineLength - 1);
            drawLine(lineLength - 1);
            drawRulerLines(lineLength - 1);
        }

    }

    /**
     * METHOD: drawRuler
     * 1. Draws the ruler line (inch 0) of specified starting length
     * 2. For each of the remaining inches:
     *      a. Draw minor rulers lines for this (1 length shorter than inch line)
     *      b. Draws the ruler line (inch i) of specified starting length
     * @param totalInches  total number of inches to include in the vertical ruler
     * @param startingLineLength number of lines (hyphens) in each inch lines
     * @return void
     */
    public static void drawRuler(int totalInches, int startingLineLength) {
// WRITE YOUR CODE HERE
        for(int i = 0; i < totalInches; i++){
            drawLine(startingLineLength);
            drawRulerLines(startingLineLength);
            drawLine(startingLineLength);
        }

    }
    // *********************************************************
    //PLEASE END YOUR CODE HERE

    public static void main( String [] args ) {
        Scanner in = new Scanner( System.in );
        int inches = in.nextInt();
        int numberParts = in.nextInt();

        drawRuler(inches,numberParts);

        in.close();

        System.out.print("END OF OUTPUT");
    }
}