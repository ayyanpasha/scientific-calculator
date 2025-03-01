package com.example.spe_mini_project;

public class Calculator {
    public static double squareRoot(double x) {
        if (x < 0) throw new IllegalArgumentException("Cannot compute square root of negative number");
        return Math.sqrt(x);
    }

    public static long factorial(int x) {
        if (x < 0) throw new IllegalArgumentException("Factorial of negative number undefined");
        if (x == 0) return 1;
        long result = 1;
        for (int i = 1; i <= x; i++) result *= i;
        return result;
    }

    public static double naturalLog(double x) {
        if (x <= 0) throw new IllegalArgumentException("Log of non-positive number undefined");
        return Math.log(x);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}