package com.cebbus;

import java.util.*;

/**
 * Created by cebbus on 08.01.2017.
 *
 * Find all possible solutions to create matrix with the following conditions.
 * -    -   -   - 3 (1), 1 (0)
 * -    -   -   - 2,2
 * -    -   -   - 1,3
 * -    -   -   - 2,2
 * 2,2  3,1 1,3 2,2
 *
 * Sample solution
 * [0, 1, 1, 1]
 * [0, 1, 0, 1]
 * [1, 0, 0, 0]
 * [1, 1, 0, 0]
 *
 *
 */
public class Exercise {

    private static byte[] rowConditions = {3, 2, 1, 2};
    private static byte[] columnConditions = {2, 3, 1, 2};
    private static List<byte[][]> matrixList = new ArrayList<>();

    public static void main(String[] args) {

        List<byte[]> setList = new ArrayList<>();
        Subset.fillSubsetBinaryList(setList, new byte[columnConditions.length], 0);

        Map<Byte, List<byte[]>> setMap = prepareSetMap(setList);

        byte order = 0;
        byte[][] emptyMatrix = new byte[rowConditions.length][columnConditions.length];
        fillMatrixList(emptyMatrix, setMap, order);

        System.out.println("Solution count : " + matrixList.size());

        for (byte[][] matrix : matrixList) {
            for (byte[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println();
            System.out.println("--------------");
            System.out.println();
        }
    }

    private static void fillMatrixList(byte[][] matrix, Map<Byte, List<byte[]>> setMap, byte order) {

        if (order == rowConditions.length) {

            if (isConditionProvided(matrix)) {
                matrixList.add(Arrays.copyOf(matrix, matrix.length));
            }

            return;
        }

        for(byte[] row : setMap.get(rowConditions[order])) {

            matrix[order] = row;

            fillMatrixList(matrix, setMap, (byte) (order+1));
        }
    }

    private static boolean isConditionProvided(byte[][] matrix) {

        boolean isConditionsOk = true;

        for (int i = 0; i < columnConditions.length; i++) {

            byte columnTotal = 0;
            for (byte[] row : matrix) {
                columnTotal += row[i];
            }

            if (columnConditions[i] != columnTotal) {
                isConditionsOk = false;
                break;
            }
        }

        return isConditionsOk;
    }

    private static Map<Byte, List<byte[]>> prepareSetMap (List<byte[]> setList) {

        Map<Byte, List<byte[]>> setMap = new HashMap<>();

        for (byte[] set : setList) {

            byte positiveCount = 0;

            for (byte val : set) {
                positiveCount += val;
            }

            if(!setMap.containsKey(positiveCount)) {
                setMap.put(positiveCount, new ArrayList<>());
            }

            setMap.get(positiveCount).add(set);
        }

        return setMap;
    }

}
