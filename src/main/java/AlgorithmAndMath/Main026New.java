package src.main.java.AlgorithmAndMath;

import java.util.Scanner;

public class Main026New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        double[] probabilities = new double[N];
        double expectedValue = 0.0;

        for (int i = 0; i < N; i++) {
            // 計算された確率を配列に格納
            probabilities[i] = 1.0 / ((double)N - i);
        }

        for (int i = 0; i < N; i++) {
            // 各コインが初めて出現するまでにかかる期待値を計算
            expectedValue += probabilities[i];
        }

        System.out.println(expectedValue);
    }
}
