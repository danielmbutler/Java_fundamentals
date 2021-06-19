package com.dbtechprojects;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {


        // validate and calculate mortgage values
        int principle = (int) readNumber("Principle (£1k - £1m) : ",1000, 1_000_000);
        float annualRate =  (float) readNumber("Annual Interest Rate: ", 1, 30);
        int totalPayments = (int) readNumber("Period (Years) : ", 1, 30);
        // calculate mortgage
        calculateMortgage(principle,annualRate,totalPayments);

    }

    // workout result https://www.wikihow.com/Calculate-Mortgage-Payments
    private static void calculateMortgage(
            int principle,
            float annulInterest,
            int years) {

        float monthIR = (annulInterest / PERCENT) / MONTHS_IN_YEAR;
        int totalMonths = (years * MONTHS_IN_YEAR);
        double method1 = monthIR * (Math.pow((1 + monthIR), totalMonths));
        double method2 = (Math.pow((1 + monthIR), totalMonths) - 1);
        //result
        double result = principle * (method1 / method2);
        printResult(result, principle,monthIR,totalMonths);
    }

    private static double readNumber(
            String prompt,
            double min,
            double max

    ){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {

            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value > min && value <= max) break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    private static void printResult(
            double result,
            int principle,
            float monthlyInterestRate,
            int numberOfPayments
    ){

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments : " +
                NumberFormat.getCurrencyInstance().format(result));

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int currentPaymentNumber = 0; currentPaymentNumber <= numberOfPayments; currentPaymentNumber++) {
            printRemainingBalance(principle, monthlyInterestRate, numberOfPayments,currentPaymentNumber);
        }

    }

    private static void printRemainingBalance(
            int principle,
            float monthlyInterestRate,
            int numberOfPayments,
            int currentPaymentNumber
    ) {
        // calculate payment schedule https://www.mtgprofessor.com/formulas.htm
        double method1 = (Math.pow((1 + monthlyInterestRate), numberOfPayments)) - Math.pow((1 + monthlyInterestRate), currentPaymentNumber);
        double method2 = (Math.pow((1 + monthlyInterestRate), numberOfPayments)) -1;
        double result = principle * (method1/method2);
        System.out.println((NumberFormat.getCurrencyInstance().format(result)));
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
