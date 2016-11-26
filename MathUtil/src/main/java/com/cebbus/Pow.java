package com.cebbus;

/**
 * Created by cebbus on 26.11.2016.
 * Calculate power of a number
 */
public class Pow {

    public static double calculate(int number, int power) {
        if(power == 1) return number;

        return number * calculate(number, power - 1);
    }

}
