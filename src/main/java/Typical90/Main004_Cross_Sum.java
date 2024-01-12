package src.main.java.Typical90;

import java.util.Scanner;

public class Main004_Cross_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] A = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        int[] rowSum = new int[H];
        int[] colSum = new int[W];
        for (int i = 0; i < H; i++) {

            for (int j = 0; j < W; j++) {
                rowSum[i] += A[i][j];
                colSum[j] += A[i][j];
            }
        }
        int[][] B = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                B[i][j] = rowSum[i] + colSum[j] - A[i][j];
            }
        }
        StringBuilder ansStr = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                ansStr.append(B[i][j]).append(" ");
            }
            ansStr.append("\n");
        }
        System.out.println(ansStr);
    }
}
