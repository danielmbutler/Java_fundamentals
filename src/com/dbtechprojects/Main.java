package com.dbtechprojects;

import java.text.NumberFormat;
import java.util.Scanner;


import static com.dbtechprojects.MortgageModel.calculateMortgage;
import static com.dbtechprojects.MortgageUtils.readNumber;

public class Main {


    public static void main(String[] args) {
        // validate and calculate mortgage values
        int principle = (int) readNumber("Principle (£1k - £1m) : ",1000, 1_000_000);
        float annualRate =  (float) readNumber("Annual Interest Rate: ", 1, 30);
        int totalPayments = (int) readNumber("Period (Years) : ", 1, 30);
        var mortgage = new MortgageModel(principle, annualRate, totalPayments);

        // calculate mortgage
        var result = calculateMortgage(mortgage);
        MortgageUtils.printResult(result, mortgage);


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
        } else if (number % 3 == 0) {
            System.out.println("Buzz");
        } else if (number % 5 == 0) {
            System.out.println("Fizz");
        } else System.out.println(number);

    }

}
