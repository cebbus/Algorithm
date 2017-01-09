package com.cebbus;

import java.util.Arrays;

/**
 * Created by cebbus on 09.01.2017.
 * u[n+1] = (c*u[n] + b) mod m
 * 0 < u[n] < m
 */
public class LineerCongruental {


    static double[] create(int count) {

        double c = 1664525;
        double b = 1013904223;
        int m = Integer.MAX_VALUE;

        double[] randoms = new double[count];

        double lastRandom = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            lastRandom = (c * lastRandom + b) % m;
            randoms[i] = lastRandom;
        }

        return randoms;
    }

    public static void main(String[] args) {

        double[] randoms = create(10);

        System.out.println(Arrays.toString(randoms));
    }

}
