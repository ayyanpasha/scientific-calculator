package com.example.spe_mini_project;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testSquareRoot() {
        assertEquals(2.0, Calculator.squareRoot(4.0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootNegative() {
        try {
            Calculator.squareRoot(-4.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot compute square root of negative number", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        try {
            Calculator.factorial(-5);
        } catch (IllegalArgumentException e) {
            assertEquals("Factorial of negative number undefined", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testNaturalLog() {
        assertEquals(1.0, Calculator.naturalLog(Math.E), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaturalLogNonPositive() {
        try {
            Calculator.naturalLog(0.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Log of non-positive number undefined", e.getMessage());
            throw e;
        }
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2.0, 3.0), 0.001);
    }
}