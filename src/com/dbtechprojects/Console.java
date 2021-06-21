package com.dbtechprojects;

import java.text.NumberFormat;
import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();


    public static double readNumber(
            String prompt,
            double min,
            double max

    ){
        double value;
        while (true) {

            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value > min && value <= max) break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static void printResult(
            double result,
            MortgageModel mortgageModel
    ){

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments : " +
                currencyInstance.format(result));

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (int currentPaymentNumber = 0; currentPaymentNumber <= mortgageModel.getTotalMonths(); currentPaymentNumber++) {
            var output = MortgageModel.calculateRemainingBalance(mortgageModel, currentPaymentNumber);
            System.out.println((currencyInstance.format(output)));
        }

    }

}
