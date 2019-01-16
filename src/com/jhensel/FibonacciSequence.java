package com.jhensel;

/**
 * @Author: Jeffrey Hensel
 * @Date: 1/11/2019
 */

public class FibonacciSequence {
    private long position = 10;

    FibonacciSequence(){
        // Defaults to position 10
    }

    FibonacciSequence(long p){
        if (p < 0)
            throw new IllegalArgumentException("Must be positive value");
        position = p;
    }

    long solve() {
        // Default cases if 0 or 1
        if (position == 0) return 0;
        if (position == 1) return 1;

        return solveHelper(2, 0, 1);
    }

    long solveHelper(long index, long firstPrevious, long secondPrevious) {
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
            long given = -1;
            try {
                given = Long.parseLong(args[0]);
            } catch (Exception e) {
                System.out.println("Input must be a numeric value: " + e.getLocalizedMessage());
            }
            if (given > 92) {
                throw new IllegalArgumentException("Only supports up to a max index of 92 due to long overflow");
            }
            if (given > 0) {
                fs = new FibonacciSequence(given);
            }
        } else {
            fs = new FibonacciSequence();
        }

        if (fs != null) {
            long result = fs.solve();
            System.out.println("Result: " + result);
        }
    }
}
