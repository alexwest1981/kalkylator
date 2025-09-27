package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// CalculatorGUI ärver från (extends) JFrame, vilket gör den till ett fönster
public class CalculatorGUI extends JFrame implements ActionListener {

    // Deklarera komponenter
    private final JTextField displayField;
    // Borta, då vi inte behöver dem som separata fält längre
    // private JButton addButton, subButton, mulButton, divButton, modButton, equalsButton, clearButton;

    // Kommer att lagra det första talet och den valda operationen
    private double num1 = 0;
    private String operator = "";
    private boolean isNewCalculation = true; // För att rensa displayen vid ny beräkning

    public CalculatorGUI() {
        // Grundläggande fönsterinställning
        setTitle("Wigellkoncernens Kalkylator GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout()); // Använder Borderlayout för fönstret

        // Displayfältet
        displayField = new JTextField("0");
        displayField.setEditable(false); // Hindrar användaren att skriva valfritt här
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 20));
        add(displayField, BorderLayout.NORTH); // Placerar displayen högst upp

        // Skapa knapp-panelen
        JPanel buttonPanel = new JPanel();
        // Använder GridLayout för att organisera knapparna i ett rutnät
        buttonPanel.setLayout(new GridLayout(5,4,5,5)); // 5x4 med 5px mellanrum

        // Skapar och lägger till knapparna
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "%", "+",
                "C", "="
        };

        for (String buttonLabel : buttonLabels) {
            JButton button = new JButton(buttonLabel);
            button.addActionListener(this); // Så knappen "lyssnar" efter input
            buttonPanel.add(button);
        }

        // Lägg till knapp-panelen i mitten av fönstret
        add(buttonPanel, BorderLayout.CENTER);

        // Gör fönstret synligt
        setLocationRelativeTo(null); // Centrerar fönstret
        setVisible(true);
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater säkerställer att GUI:et körs på rätt tråd
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Hämtar texten på knappen som klickades

        // Hantera siffror och decimaltecken
        if (command.matches("[0-9]") || command.equals(".")) {
            if (isNewCalculation) {
                displayField.setText(command.equals(".") ? "0." : command);
                isNewCalculation = false;
            } else {
                // Förhindrar multipla decimaltecken
                if (command.equals(".") && displayField.getText().contains(".")) {
                    return;
                }
                displayField.setText(displayField.getText() + command);
            }
        }

        // Hantera rensning
        else if (command.equals("C")) {
            displayField.setText("0");
            num1 = 0;
            operator ="";
            isNewCalculation = true;
        }

        // Hantera operatorer (+, -, *, /, %)
        else if (command.matches("[+\\-*/%]")) {
            try {
                // Lagra första talet
                num1 = Double.parseDouble(displayField.getText());
                operator = command;
                isNewCalculation = true; // Nästa inmatning ska rensa displayen
            } catch (NumberFormatException ex) {
                displayField.setText("Fel!");
                isNewCalculation = true;
            }
        }

        // Hantera likamed-tecknet
        else if (command.equals("=")) {
            if (operator.isEmpty()) {
                return; // Inget görs om ingen operator har valts
            }

            try {
                double num2 = Double.parseDouble(displayField.getText());
                double result;

                // Anropa den rena logik-klassen baserat på operatorn
                result = switch (operator) {
                    case "+" -> CalculatorLogic.add(num1, num2);
                    case "-" -> CalculatorLogic.subtract(num1, num2);
                    case "*" -> CalculatorLogic.multiply(num1, num2);
                    case "/" -> CalculatorLogic.divide(num1, num2);
                    case "%" -> CalculatorLogic.modulus(num1, num2);
                    default -> throw new IllegalStateException("Unexpected operator: " + operator);
                };

                displayField.setText(String.valueOf(result));
                num1 = result; // Spara resultatet som det nya första talet för kedjeberäkning
                operator = "";
                isNewCalculation = true;
            } catch (NumberFormatException ex) {
                displayField.setText("Input Error");
                isNewCalculation = true;
            } catch (ArithmeticException ex) {
                // Fånga fel från CalculatorLogic (t. ex. Division med noll)
                displayField.setText(ex.getMessage());
                num1 = 0;
                operator = "";
                isNewCalculation = true;
            }
        }
    }
}