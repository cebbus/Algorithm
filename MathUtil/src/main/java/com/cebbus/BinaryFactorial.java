package com.cebbus;

/**
 * Created by cebbus on 13.12.2016.
 * Calculate binary factorial
 */
public class BinaryFactorial {

    public static int calculate(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("The number should be greater than 0.");
        }

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        return n * calculate(n - 2);
    }

}
