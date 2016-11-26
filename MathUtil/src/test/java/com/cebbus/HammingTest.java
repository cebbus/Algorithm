package com.cebbus;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HammingTest {
    @Test
    public void findHammingNumbers() throws Exception {

        List<Integer> hammingNumbers = Hamming.findHammingNumbers(10);

        int[] actual = new int[hammingNumbers.size()];

        for (int i = 0; i <  hammingNumbers.size(); i++) {
            actual[i] = hammingNumbers.get(i);
        }

        assertArrayEquals(new int[]{2,3,4,5,6,8,9,10}, actual);
    }

}