package com.cebbus;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by cebbus on 08.01.2017.
 * John von Neumann
 */
public class JohnNeumann {

    static double[] create(int count, int digit) {

        String baseStr = new StringBuilder(String.valueOf(System.currentTimeMillis())).reverse().toString();

        String temp;
        Double n = Double.parseDouble(baseStr.substring(0, digit * 4));

        double[] randoms = new double[count];

        for (int i = 0; i < count; i++) {
            temp = new BigDecimal(n).toPlainString();

            randoms[i] = Double.parseDouble(temp.substring(0, digit));

            temp = temp.substring(digit, temp.length() - digit);

            if (temp.startsWith("0")) {
                temp = "9" + temp.substring(1);
            }

            n = Double.parseDouble(temp);

            n = n * n;
        }

        return randoms;

    }

    public static void main(String[] args) {
        double[] randoms = create(10, 2);
        System.out.println(Arrays.toString(randoms));
    }

}
