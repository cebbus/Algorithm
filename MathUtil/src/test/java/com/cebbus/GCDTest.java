package com.cebbus;

import org.junit.Test;

import static org.junit.Assert.*;

public class GCDTest {
    @Test
    public void findGCD() throws Exception {

        int gcd = GCD.findGCD(162, 72);

        assert Integer.compare(18, gcd) == 0;
    }

}