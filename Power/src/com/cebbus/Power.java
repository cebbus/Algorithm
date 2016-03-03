package com.cebbus;

import java.util.Scanner;

/**
 * Created by cebbus on 04.03.2016.
 * Calculate power of a number
 */
public class Power {

    public static double calculate(int number, int power) {
        if(power == 1) return number;

        return number * calculate(number, power - 1);
    }

    public static void main(String[] args) {
        System.out.print("Enter a number : ");

        Scanner s = new Scanner(System.in);
        String number = s.nextLine();

        System.out.print("Enter a power : ");
        String power = s.nextLine();

        try {
            int n = Integer.parseInt(number);
            int p = Integer.parseInt(power);

            System.out.println(calculate(n, p));
        } catch (NumberFormatException e) {
            System.err.println("Not a number : " + number + " or " + power);
        } catch (Exception e) {
            System.err.println("Something is wrong " + e.getMessage());
        }

        System.out.print("Press enter to exit...");
        s.nextLine();
        System.exit(0);
    }
}
