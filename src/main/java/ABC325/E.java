package src.main.java.ABC325;

import java.util.Scanner;

public class E {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        long[][]D = new long[N][N];
        long[][]dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                D[i][j] = scanner.nextLong();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(i+1 <= j){
                    for (int k = i; k < j ; k++) {
                        long distance = D[k][j] * B + C;
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + distance);
                    }

                }else{
                    for (int k = 0; k <= j; k++) {
                        long distance = D[k][j] * A;
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + distance);

                    }
                }

            }
        }
        long ans = Long.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            ans = Math.min(ans, dp[j][N-1]);
        }
        System.out.println(ans);
    }

}
