package org.example;

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


    // Separata metoder för varje beräkningstyp för bättre struktur
    public static void performAddition(Scanner scanner) {
        System.out.println(ANSI_GREEN + "Du valde addition." + ANSI_RESET);
        System.out.println("Ange det första talet för att starta beräkningen:");
        double result;

        // Loop för att få det första talet
        while (true) {
            try {
                System.out.print("Ange första talet: ");
                String input = scanner.nextLine();
                result = Double.parseDouble(input);
                break; // Avslutar loopen om inmatningen är korrekt
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println("Ange fler tal att addera. Skriv 'E' när du är klar.");

        while (true) {
            try {
                System.out.print("Ange ett tal: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("E")) {
                    break; // Avslutar loopen för att slutföra beräkningen
                }
                double number = Double.parseDouble(input);
                result += number; // Addera nästa tal till resultatet
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror eller 'E'." + ANSI_RESET);
            }
        }

        System.out.println(ANSI_GREEN + "Resultatet av additionen är: " + result + ANSI_RESET);
        System.out.println();
    }

    public static void performSubtraction(Scanner scanner) {
        System.out.println(ANSI_YELLOW + "Du valde subtraction." + ANSI_RESET);
        System.out.println("Ange det första talet för att starta beräkningen:");
        double result;

        // Använd en loop för att få det första talet
        while (true) {
            try {
                System.out.print("Ange första talet: ");
                String inout = scanner.nextLine();
                result = Double.parseDouble(inout);
                break; // Avsluta loopen om inmatningen är korrekt
            }  catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println("Ange fler tal att subtrahera. Skriv 'E' när du är klar.");

        while (true) {
            try {
                System.out.print("Ange ett tal: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("E")) {
                    break; // Avslutar loopen för att slutföra beräkningen
                }
                double number = Double.parseDouble(input);
                result -= number; // Subtrahera nästa tal från resultatet
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format.Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println(ANSI_YELLOW + "Resultatet av subtraktionen är: " + result + ANSI_RESET);
        System.out.println();
    }

    public static void performMultiplication(Scanner scanner) {
        System.out.println(ANSI_CYAN + "Du valde multiplication." + ANSI_RESET);
        System.out.println("Ange det första talet för att starta beräkningen:");
        double result;

        // Loop för det första talet
        while (true) {
            try {
                System.out.println("Ange första talet: ");
                String input = scanner.nextLine();
                result = Double.parseDouble(input);
                break;
            }  catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println("Ange fler tal att multiplicera. Skriv 'E' när du är klar.");

        while (true) {
            try {
                System.out.print("Ange ett tal: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("E")) {
                    break; // Avslutar loopen för att slutföra beräkningen
                }
                double number = Double.parseDouble(input);
                result *= number;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println(ANSI_CYAN + "Resultatet av multiplikationen är " + result + ANSI_RESET);
        System.out.println();
    }

    public static void performDivision(Scanner scanner) {
        System.out.println(ANSI_PURPLE + "Du valde division." + ANSI_RESET);
        System.out.println("Ange täljaren för att starta beräkningen:");
        double result;

        // Loop för att få det första talet (täljaren)
        while (true) {
            try {
                System.out.print("Ange täljare: ");
                String input = scanner.nextLine();
                result = Double.parseDouble(input);
                break; // Avslutar loopen om inmatningen är korrekt
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println("Ange fler nämnare att dividera med. Skriv 'E' när du är klar.");

        while (true) {
            try {
                System.out.print("Ange en nämnare: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("E")) {
                    break; // Avslutar loopen för att slutföra beräkningen
                }
                double number = Double.parseDouble(input);
                if (number == 0) {
                    System.out.println(ANSI_RED + "Fel: Det går inte att dividera med noll." + ANSI_RESET);
                    // Fortsätt till nästa loop-iteration utan att krascha
                    continue;
                }
                result /= number;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror eller 'E'." + ANSI_RESET);
            }
        }

        System.out.println(ANSI_PURPLE + "Resultatet av divisionen är: " + result + ANSI_RESET);
        System.out.println();
    }

    public static void performModulus(Scanner scanner) {
        System.out.println(ANSI_RED + "Du valde modulus." + ANSI_RESET);
        System.out.println("Ange det första talet:");
        double result;

        // Loop för att få det första talet
        while (true) {
            try {
                System.out.print("Ange första talet: ");
                String input = scanner.nextLine();
                result = Double.parseDouble(input);
                break; // Avslutar loopen om inmatningen är korrekt
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror." + ANSI_RESET);
            }
        }

        System.out.println("Ange fler tal att beräkna modulus med. Skriv 'E' när du är klar.");

        while (true) {
            try {
                System.out.print("Ange ett tal: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("E")) {
                    break; // Avslutar loopen för att slutföra beräkningen
                }
                double number = Double.parseDouble(input);
                if (number == 0) {
                    System.out.println(ANSI_RED + "Fel: Det går inte att beräkna modulus med noll." + ANSI_RESET);
                    // Fortsätt till nästa loop-iteration
                    continue;
                }
                result %= number;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Ogiltigt format. Vänligen ange endast siffror eller 'E'." + ANSI_RESET);
            }
        }

        System.out.println(ANSI_RED + "Resultatet av modulus är: " + result + ANSI_RESET);
        System.out.println();
    }
}