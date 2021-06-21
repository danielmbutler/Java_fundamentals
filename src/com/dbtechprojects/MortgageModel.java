package com.dbtechprojects;

public class MortgageModel {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private int principle;
    private float annualInterest;
    private int mortgageLength;
    private final float monthlyInterest;
    private final int totalMonths;


    // workout result https://www.wikihow.com/Calculate-Mortgage-Payments
    public static double calculateMortgage(
            MortgageModel mortgageModel) {

        double pow = Math.pow((1 + mortgageModel.monthlyInterest), mortgageModel.totalMonths);
        double method1 = mortgageModel.monthlyInterest * pow;
        double method2 = (pow - 1);

        return mortgageModel.getPrinciple() * (method1 / method2);

    }

    // calculate payment schedule https://www.mtgprofessor.com/formulas.htm
    public static double calculateRemainingBalance(MortgageModel mortgageModel, int currentPaymentNumber) {
        double method1 = (Math.pow((1 + mortgageModel.getMonthlyInterest()), mortgageModel.getTotalMonths())) -
                Math.pow((1 + mortgageModel.getMonthlyInterest()), currentPaymentNumber);
        double method2 = (Math.pow((1 + mortgageModel.getMonthlyInterest()), mortgageModel.getTotalMonths())) - 1;
        return mortgageModel.getPrinciple() * (method1 / method2);
    }

    public MortgageModel(int principle, float annualInterest, int mortgageLength) {
        setAnnualInterest(annualInterest);
        setPrinciple(principle);
        setMortgageLength(mortgageLength);
        this.monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
        this.totalMonths = mortgageLength * MONTHS_IN_YEAR;

    }

    public int getPrinciple() {
        return principle;
    }

    private void setPrinciple(int principle) {
        this.principle = principle;
    }

    private void setMortgageLength(int mortgageLength) {
        this.mortgageLength = mortgageLength;
    }

    private void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }


    public float getMonthlyInterest() {
        return monthlyInterest;
    }

    public int getTotalMonths() {
        return totalMonths;
    }
}
