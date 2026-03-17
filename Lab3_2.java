import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int largest = Integer.MIN_VALUE;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter number: ");
            int num = input.nextInt();

            if (num > largest) {
                largest = num;
            }
        }

        System.out.println("Largest number is: " + largest);

        input.close();
    }
}