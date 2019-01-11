package com.jhensel;

/**
 * @Author: Jeffrey Hensel
 * @Date: 1/11/2019
 */

public class FibonacciSequence {
    private int position = 10;

    FibonacciSequence(){
        // Defaults to position 10
    }

    FibonacciSequence(int p){
        if (p < 0)
            throw new IllegalArgumentException("Must be positive value");
        position = p;
    }

    int solve() {
        // Default cases if 0 or 1
        if (position == 0) return 0;
        if (position == 1) return 1;

        return solveHelper(2, 0, 1);
    }

    int solveHelper(int index, int firstPrevious, int secondPrevious) {
        if (index == position) {
            return firstPrevious + secondPrevious;
        } else {
            return solveHelper(++index, secondPrevious, firstPrevious + secondPrevious);
        }
    }


    public static void main(String[] args) {
        FibonacciSequence fs = null;

        // Optional arg can be passed in with the index we want to find
        if (args.length > 0) {
            int given = -1;
            try {
                given = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.println("Input must be a numeric value " + e.getLocalizedMessage());
            }
            if (given > 0) {
                fs = new FibonacciSequence(given);
            }
        } else {
            fs = new FibonacciSequence();
        }

        if (fs != null) {
            int result = fs.solve();
            System.out.println("Result: " + result);
        }
    }
}
