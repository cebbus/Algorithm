package com.cebbus;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryFactorialTest {
    @Test
    public void calculate() throws Exception {
        assertEquals(48, BinaryFactorial.calculate(6));
    }
}