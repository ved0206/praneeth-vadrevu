import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    public static double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = sc.nextDouble();

            System.out.print("Enter operation (+, -, *, /): ");
            char operator = sc.next().charAt(0);

            double result = 0;
            boolean valid = true;

            switch (operator) {
                case '+':
                    result = add(num1, num2);
                    break;
                case '-':
                    result = subtract(num1, num2);
                    break;
                case '*':
                    result = multiply(num1, num2);
                    break;
                case '/':
                    result = divide(num1, num2);
                    break;
                case '^':
                    result = power(num1, (int) num2);
                    break;
                default:
                    System.out.println("Error: Invalid operation.");
                    valid = false;
            }

            if (valid) {
                System.out.println("Result: " + result);
            }

            System.out.print("Do you want to perform another calculation? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println(" ");
        sc.close();
    }
}