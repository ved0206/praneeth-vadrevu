import java.util.Scanner;

public class Analyzer {

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int getFactorial(int num) {
        int factorial = 1;

        for (int i = num; i >=1; i--) {
            factorial = factorial * i;
        }

        return factorial;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }

        return sum;
    }

    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num = num / 10;
        }

        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Is Even: " + isEven(num));
        System.out.println("Is Prime: " + isPrime(num));
        System.out.println("Factorial: " + getFactorial(num));
        System.out.println("Sum of Digits: " + sumOfDigits(num));
        System.out.println("Reverse Number: " + reverseNumber(num));

        sc.close();
    }
}