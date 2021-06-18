package com.dbtechprojects;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        //Scanner to collect values
        Scanner scanner = new Scanner(System.in);
        //currency Instance
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        //logic

        //principal
        System.out.print("Principle (£1k - £1m) : ");
        int principle = scanner.nextInt();
        // condition
        while (!(principle >= 1000 && principle <= 1_000_000)){
            System.out.println("Enter a number between 1000 and 1,000,000");
            System.out.print("Principle: ");
            principle = scanner.nextInt();
        }

        //rate
        System.out.print("Rate: ");
        float rate = scanner.nextFloat();
        // condition
        while (!(rate > 0 && rate <= 30)){
            System.out.println("Enter a value greater than 1 but less than 30");
            System.out.print("Rate: ");
            rate = scanner.nextFloat();
        }

        //period
        System.out.print("Period (Years) : ");
        int period = scanner.nextInt();
        // condition
        while (!(period > 1 && period <= 30)){
            System.out.println("Enter a value greater than 1 but less than 30");
            System.out.print("Period (Years) : ");
            period = scanner.nextInt();
        }

        // workout result https://www.wikihow.com/Calculate-Mortgage-Payments
        float monthIR = (rate / PERCENT) / MONTHS_IN_YEAR;
        int totalMonths = (period * MONTHS_IN_YEAR);
        double method1 = monthIR * (Math.pow((1 + monthIR), totalMonths));
        double method2 = (Math.pow((1 + monthIR), totalMonths) - 1);
        //result
        double result = principle * (method1 / method2);
        //printout
        System.out.println("Monthly Payment: " + currency.format(result));

    }


    // test ternary operator
    private static void test() {
        int income = 120_000;
        String className = income > 100_000 ? "First" : "Economy";
        System.out.println(className);
    }

    /*
      for (int i = 0; i < 100; i++) {
            fizzBuzz(i);
        }
     */

    private static void fizzBuzz(final int number) {

        System.out.print("Number: ");

        if ((number % 3 == 0) && (number % 5 == 0)) {
            System.out.println("FizzBuzz");
        }
        else if (number % 3 == 0){
            System.out.println("Buzz");
        }
        else if(number % 5 == 0){
            System.out.println("Fizz");
        }
        else System.out.println(number);

    }

}
