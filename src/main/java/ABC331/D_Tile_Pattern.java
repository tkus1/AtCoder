package src.main.java.ABC331;

import java.util.Scanner;

public class D_Tile_Pattern {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        char[][] P = new char[N][N];
        int[][] g = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = scanner.next();
            for (int j = 0; j < N; j++) {
                P[i][j] = str.charAt(j);
            }
        }
        if (P[0][0] == 'B') {
            g[0][0] = 1;
        } else {
            g[0][0] = 0;
        }
        for (int i = 1; i < N; i++) {
            g[i][0] = g[i-1][0];
            if(P[i][0] == 'B'){
                g[i][0]++;
            }
        }
        for (int i = 1; i < N; i++) {
            g[0][i] = g[0][i-1];
            if(P[0][i] == 'B'){
                g[0][i]++;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                g[i][j] = g[i-1][j] + g[i][j-1] - g[i-1][j-1];
                if(P[i][j] == 'B'){
                    g[i][j]++;
                }
            }
        }

        StringBuilder ansStr = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            int D = scanner.nextInt();
            long ans =   Helper.blackCnt(g, N, C, D);
            if(A > 0){
                ans -= Helper.blackCnt(g, N, A-1, D);
            }
            if(B > 0){
                ans -= Helper.blackCnt(g, N, C, B-1);
            }
            if(A > 0 && B > 0){
                ans += Helper.blackCnt(g, N, A-1, B-1);
            }
            ansStr.append(ans).append("\n");
        }

        System.out.println(ansStr);



    }
    public static class Helper{
        public static long blackCnt(int[][]g, int N, int A, int B){
            int fullCntA = (A+1) / N;
            int residualA = (A+1) % N;
            int fullCntB = (B+1) / N;
            int residualB = (B+1) % N;
            int fullCnt = g[N-1][N-1];
            long sum = 0;
            sum += fullCnt * ((long) fullCntB * fullCntA);
            if(residualB > 0){
                sum += (long) g[N - 1][residualB - 1] * fullCntA;
            }
            if (residualA > 0){
                sum += (long) g[residualA - 1][N - 1] * fullCntB;
            }
            if(residualA > 0 && residualB > 0){
                sum += g[residualA-1][residualB-1];
            }
            return sum;
        }
    }
}
