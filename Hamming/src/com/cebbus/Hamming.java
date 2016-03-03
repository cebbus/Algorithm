package com.cebbus;

import java.util.Scanner;

/**
 * Created by cebbus on 03.03.2016.
 * Find hamming numbers
 */
public class Hamming {

    public static boolean isHamming(int number) {

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

    public static void findHammingNumbers(int number) {
        if (number <= 1) {
            return;
        }

        findHammingNumbers(number - 1);

        if(isHamming(number)) {
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a number : ");

        Scanner s = new Scanner(System.in);
        String line = s.nextLine();

        try {
            int i = Integer.parseInt(line);
            findHammingNumbers(i);
            System.out.println("");
        } catch (NumberFormatException e) {
            System.err.println("Not a number : " + line);
        } catch (Exception e) {
            System.err.println("Something is wrong " + e.getMessage());
        }

        System.out.print("Press enter to exit...");
        s.nextLine();
        System.exit(0);
    }
}
