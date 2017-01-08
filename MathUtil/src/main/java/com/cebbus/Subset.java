package com.cebbus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cebbus on 10.12.2016.
 * Find subsets
 */
class Subset {

    static void fillSubsetBinaryList(List<byte[]> subsetList, byte[] subset, int order) {

        if (order == subset.length) {
            subsetList.add(Arrays.copyOf(subset, subset.length));
            return;
        }

        subset[order] = 0;
        fillSubsetBinaryList(subsetList, subset, order+1);

        subset[order] = 1;
        fillSubsetBinaryList(subsetList, subset, order+1);

    }

    static<T> List<ArrayList<T>> findSubsets(List<T> cluster) {

        byte[] binaryList = new byte[cluster.size()];

        int subsetSize = (int) Pow.calculate(2, cluster.size());
        List<byte[]> subsetList = new ArrayList<>(subsetSize);

        fillSubsetBinaryList(subsetList, binaryList, 0);

        List<ArrayList<T>> resultList = new ArrayList<>(subsetList.size());
        for (byte[] subsetBinary : subsetList) {

            ArrayList<T> subset = new ArrayList<>();

            for (int i = 0; i < subsetBinary.length; i++) {
                if (subsetBinary[i] == 1) {
                    subset.add(cluster.get(i));
                }
            }

            resultList.add(subset);
        }

        return resultList;
    }

}
