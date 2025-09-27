package org.example;

public class CalculatorLogic {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            // Vi kastar ett fel som GUI måste fånga
            throw new ArithmeticException("Division med noll är inte tillåtet.");
        }
        return num1 / num2;
    }

    public static double modulus(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Modulus med noll är inte tillåtet.");
        }
        return num1 % num2;
    }
}
