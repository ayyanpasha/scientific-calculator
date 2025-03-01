package com.example.spe_mini_project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            if (choice == 5) break;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter x: ");
                        double x = scanner.nextDouble();
                        System.out.println("Result: " + Calculator.squareRoot(x));
                        break;
                    case 2:
                        System.out.print("Enter x: ");
                        int n = scanner.nextInt();
                        System.out.println("Result: " + Calculator.factorial(n));
                        break;
                    case 3:
                        System.out.print("Enter x: ");
                        double lnX = scanner.nextDouble();
                        System.out.println("Result: " + Calculator.naturalLog(lnX));
                        break;
                    case 4:
                        System.out.print("Enter base (x): ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent (b): ");
                        double exponent = scanner.nextDouble();
                        System.out.println("Result: " + Calculator.power(base, exponent));
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}