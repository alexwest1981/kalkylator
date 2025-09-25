package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                    System.out.println(ANSI_GREEN + "Du valde addition." + ANSI_RESET);
                    break;
                case "-":
                    System.out.println(ANSI_YELLOW + "Du valde subtraktion." + ANSI_RESET);
                    break;
                case "*":
                    System.out.println(ANSI_CYAN + "Du valde multiplikation." + ANSI_RESET);
                    break;
                case "/":
                    System.out.println(ANSI_PURPLE + "Du valde division." + ANSI_RESET);
                    break;
                case "%":
                    System.out.println(ANSI_RED + "Du valde modulus." + ANSI_RESET);
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
}