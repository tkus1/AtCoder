package src.main.java.AlgorithmAndMath;


import java.util.Scanner;

public class Main023 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long b = 0;
        for (int i = 0; i < N; i++) {
            b += scanner.nextInt();
        }
        long r = 0;
        for (int i = 0; i < N; i++) {
            r += scanner.nextInt();
        }

        System.out.println((float) (b + r) / N);

    }
}
