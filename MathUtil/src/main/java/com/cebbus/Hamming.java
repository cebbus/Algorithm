package com.cebbus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cebbus on 26.11.2016.
 * Find hamming numbers
 */
public class Hamming {

    private static boolean isHamming(int number) {

        if(number == 1) return true;

        if(number % 2 == 0) {
            return isHamming(number / 2);
        } else if (number % 3 == 0) {
            return isHamming(number / 3);
        } else if (number % 5 == 0) {
            return isHamming(number / 5);
        }

        return false;
    }

    public static List<Integer> findHammingNumbers(int number) {

        if (number < 1) {
            throw new IllegalArgumentException("Number must be greater than 1.");
        }

        List<Integer> hammingList = new ArrayList<>(number);

        for (int i = number; i > 1; i--) {
            if(isHamming(i)) {
                hammingList.add(i);
            }
        }

        hammingList.sort(Integer::compareTo);

        return hammingList;
    }

}
