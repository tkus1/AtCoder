package src.main.java.Typical90;

import java.util.Scanner;

public class Main079 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        long[][] A = new long[H][W];
        long[][] B = new long[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = scanner.nextLong();
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                B[i][j] = scanner.nextLong();
            }
        }
        long[][] diff = new long[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W ; j++) {
                diff[i][j] = B[i][j] - A[i][j];
            }
        }
        long ansCnt = 0;
        for (int i = 0; i < H-1; i++) {
            for (int j = 0; j < W-1; j++) {
                if(diff[i][j] != 0){
                    long operationCnt = diff[i][j];
                    addNumForFourTiles(diff, i, j, -operationCnt);
                    ansCnt+= Math.abs(operationCnt);
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(diff[i][j] != 0){
                    System.out.println("No");
                    return;
                }
            }
        }

        System.out.println("Yes");
        System.out.println(ansCnt);

    }
    public static void addNumForFourTiles(long[][] diff, int i, int j, long num){
        diff[i][j] += num;
        diff[i+1][j] += num;
        diff[i][j+1] += num;
        diff[i+1][j+1] += num;
    }
}
