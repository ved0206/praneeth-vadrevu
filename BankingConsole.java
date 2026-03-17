import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Part 1 - Account Setup
        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        // Process name
        String trimmedName = fullName.trim();
        String upperName = trimmedName.toUpperCase();

        String firstName;
        int space = trimmedName.indexOf(" ");
        if (space != -1) {
            firstName = trimmedName.substring(0, space);
        } else {
            firstName = trimmedName;
        }

        int Count = trimmedName.replace(" ", "").length();

        // Part 2 - Account Number Validation
        boolean verification = true;

        if (accountNumber.length() != 8) {
            verification = false;
        } else if (accountNumber.charAt(0) != '1') {
            verification = false;
        } else {
            for (int i = 0; i < accountNumber.length(); i++) {
                if (!Character.isDigit(accountNumber.charAt(i))) {
                    verification = false;
                    break;
                }
            }
        }

        if (!verification) {
            System.out.println("Invalid Account number");
            sc.close();
            return;
        }

        // Part 3 - Transaction Simulation
        System.out.print("\nEnter deposit amount: ");
        double deposit = sc.nextDouble();
        balance += deposit;

        System.out.print("Enter withdrawal amount: ");
        double withdrawal = sc.nextDouble();
        balance -= withdrawal;
        sc.nextLine(); // consume newline

        // Part 4 - Secure Login
        String pin;
        while (true) {
            System.out.print("\nCreate a 4-digit PIN: ");
            pin = sc.nextLine();

            boolean validPin = true;

            if (pin.length() != 4) {
                validPin = false;
            } else {
                for (int i = 0; i < pin.length(); i++) {
                    if (!Character.isDigit(pin.charAt(i))) {
                        validPin = false;
                        break;
                    }
                }
            }
            if (validPin) {
                break;
            } else {
                System.out.println("Invalid PIN. Must be exactly 4 digits.");
            }
        }
        System.out.print("Re-enter PIN to login: ");
        String login = sc.nextLine();

        if (pin.equals(login)) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Incorrect Pin");
        }

        // Part 5 - Final Account Summary

        System.out.println("\nACCOUNT SUMMARY");
        System.out.println("---------------");
        System.out.println("Name: " + upperName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Final Balance: $%.2f%n", balance);

        sc.close();
    }
}