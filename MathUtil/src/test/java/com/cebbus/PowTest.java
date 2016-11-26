package com.cebbus;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {
    @Test
    public void calculate() throws Exception {

        double result = Pow.calculate(5, 3);

        assertEquals(125, result, 1E-1);

    }

}