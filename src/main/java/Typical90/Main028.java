package src.main.java.Typical90;

import java.util.Scanner;

public class Main028 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        final int W = 1001;
        final int H = 1001;
        int[][] A = new int[1001][1001];
        for (int n = 0; n < N; n++) {
            int lx = scanner.nextInt();
            int ly = scanner.nextInt();
            int rx = scanner.nextInt();
            int ry = scanner.nextInt();
            for (int i = ly; i < ry; i++) {
                A[i][lx] += 1;
                A[i][rx] -= 1;
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 1; j < W; j++) {
                A[i][j] += A[i][j - 1];
            }
        }
        int[] ansCnt = new int[N+1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                ansCnt[A[i][j]] += 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.println(ansCnt[i]);
        }
    }
}
