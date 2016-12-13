package com.cebbus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetTest {
    @Test
    public void findSubsets() throws Exception {

        List<String> cluster = new ArrayList<>(2);
        cluster.add("A");
        cluster.add("B");

        List<List<String>> expected = new ArrayList<>();
        ArrayList<String> subset = new ArrayList<>();

        expected.add(subset);

        subset = new ArrayList<>();
        subset.add("B");
        expected.add(subset);

        subset = new ArrayList<>();
        subset.add("A");
        expected.add(subset);

        subset = new ArrayList<>();
        subset.add("A");
        subset.add("B");
        expected.add(subset);

        List<ArrayList<String>> actual = Subset.findSubsets(cluster);

        assertEquals(expected, actual);

    }

}