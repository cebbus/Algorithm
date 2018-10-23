package com.cebbus;

import org.junit.Test;

public class GCDTest {
    @Test
    public void findGCD() throws Exception {

        int gcd = GCD.findGCD(162, 72);

        assert 18 == gcd;
    }

}