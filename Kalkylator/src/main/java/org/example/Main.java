package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // ANSI-färger som konstanter
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        // ASCII-intro för kalkylatorn
        System.out.println(" __     __     __     ______     ______     __         __            ______     ______     __         ______");
        System.out.println("/\\ \\  _ \\ \\   /\\ \\   /\\  ___\\   /\\  ___\\   /\\ \\       /\\ \\          /\\  ___\\   /\\  __ \\   /\\ \\       /\\  ___\\");
        System.out.println("\\ \\ \\/ \".\\ \\  \\ \\ \\  \\ \\ \\__ \\  \\ \\  __\\   \\ \\ \\____  \\ \\ \\____     \\ \\ \\____  \\ \\  __ \\  \\ \\ \\____  \\ \\ \\____");
        System.out.println(" \\ \\__/\".~\\_\\  \\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\     \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_____\\");
        System.out.println("  \\/_/   \\/_/   \\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_____/      \\/_____/   \\/_/\\/_/   \\/_____/   \\/_____/");
        System.out.println("Välkommen till Wigellkoncernens Kalkylator!");
        System.out.println("---------------------------------------------");

        Scanner scanner = new Scanner(System.in);
        boolean fortsatt = true;

        while (fortsatt) {
            System.out.println("Välj ett räknesätt: " + ANSI_GREEN + "(+) " + ANSI_YELLOW + "(-) " + ANSI_CYAN + "(*) " + ANSI_PURPLE + "(/) " + ANSI_RED + "(%)" + ANSI_RESET + " eller 'E' för att avsluta:");
            String val = scanner.nextLine();

            switch (val) {
                case "+":
                    performAddition(scanner);
                    break;
                case "-":
                    performSubtraction(scanner);
                    break;
                case "*":
                    performMultiplication(scanner);
                    break;
                case "/":
                    performDivision(scanner);
                    break;
                case "%":
                    performModulus(scanner);
                    break;
                case "E":
                    System.out.println("Avslutar programmet.");
                    fortsatt = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }
        scanner.close();
    }

    // Metod för att läsa in och validera tal från användaren
    public static double readValidatedNumber(Scanner scanner, String prompt) {
        double number = 0.0;
        boolean valid = false;
        do {
            try {
                System.out.println(prompt);
                number = scanner.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
                scanner.nextLine(); // Rensa scannern
            }
        } while (!valid);
        return number;
    }

    // Separata metoder för varje beräkningstyp för bättre struktur
    public static void performAddition(Scanner scanner) {
        System.out.println(ANSI_GREEN + "Du valde addition." + ANSI_RESET);
        double firstNumber = readValidatedNumber(scanner, "Ange första talet:");
        double secondNumber = readValidatedNumber(scanner, "Ange andra talet:");
        double result = firstNumber + secondNumber;
        System.out.println(ANSI_GREEN + "Resultatet av additionen är: " + result + ANSI_RESET);
        scanner.nextLine(); // Rensa scannern för att undvika problem med menyn
        System.out.println();
    }

    public static void performSubtraction(Scanner scanner) {
        System.out.println(ANSI_YELLOW + "Du valde subtraktion." + ANSI_RESET);
        double firstNumber = readValidatedNumber(scanner, "Ange första talet:");
        double secondNumber = readValidatedNumber(scanner, "Ange andra talet:");
        double result = firstNumber - secondNumber;
        System.out.println(ANSI_YELLOW + "Resultatet av subtraktionen är: " + result + ANSI_RESET);
        scanner.nextLine();
        System.out.println();
    }

    public static void performMultiplication(Scanner scanner) {
        System.out.println(ANSI_CYAN + "Du valde multiplikation." + ANSI_RESET);
        double firstNumber = readValidatedNumber(scanner, "Ange första talet:");
        double secondNumber = readValidatedNumber(scanner, "Ange andra talet:");
        double result = firstNumber * secondNumber;
        System.out.println(ANSI_CYAN + "Resultatet av multiplikationen är: " + result + ANSI_RESET);
        scanner.nextLine();
        System.out.println();
    }

    public static void performDivision(Scanner scanner) {
        System.out.println(ANSI_PURPLE + "Du valde division." + ANSI_RESET);
        double firstNumber = readValidatedNumber(scanner, "Ange täljaren:");
        double secondNumber = readValidatedNumber(scanner, "Ange nämnaren:");
        if (secondNumber == 0) {
            System.out.println(ANSI_RED + "Fel: Det går inte att dividera med noll." + ANSI_RESET);
        } else {
            double result = firstNumber / secondNumber;
            System.out.println(ANSI_PURPLE + "Resultatet av divisionen är: " + result + ANSI_RESET);
        }
        scanner.nextLine();
        System.out.println();
    }

    public static void performModulus(Scanner scanner) {
        System.out.println(ANSI_RED + "Du valde modulus." + ANSI_RESET);
        double firstNumber = readValidatedNumber(scanner, "Ange första talet:");
        double secondNumber = readValidatedNumber(scanner, "Ange andra talet:");
        double result = firstNumber % secondNumber;
        System.out.println(ANSI_RED + "Resultatet av modulus är: " + result + ANSI_RESET);
        scanner.nextLine();
        System.out.println();
    }
}