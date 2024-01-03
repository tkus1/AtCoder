package src.main.java.BeginnersSelection;

import java.util.Scanner;

public class ABC083B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        long sum = 0;
        for (int i = 1; i <=N ; i++) {
            int number = i;
            int sumOfDigits = 0;
            while (number > 0) {
                int digit = number % 10;
                sumOfDigits += digit;
                number /= 10;
            }
            if(A <= sumOfDigits && sumOfDigits <= B){
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
