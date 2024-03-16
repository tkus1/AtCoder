package src.main.java.ABC344;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String T = scanner.next();
        int N = scanner.nextInt();
        int[][] dp = new int[N+1][T.length()+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < T.length()+1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            for (int j = 0; j < A; j++) {
                String s = scanner.next();
                for (int col = 0; col < T.length(); col++) {
                    dp[i+1][col] = Math.min(dp[i+1][col], dp[i][col]);
                    if(dp[i][col] != Integer.MAX_VALUE) {
                        dp[i+1][col] = Math.min(dp[i+1][col], dp[i][col]);
                        int pointer = 0;
                        while(T.charAt(col + pointer)==s.charAt(pointer)) {
                            pointer++;
                            if(pointer == s.length()) {
                                break;
                            }
                            if(col + pointer == T.length()) {
                                break;
                            }
                        }

                        if(pointer == s.length()){
                            System.out.println("all match, i= "+ i+" string = " + s +" from "+ col + " to " + (col + pointer));
                            dp[i+1][col+pointer] = Math.min(dp[i+1][col+pointer], dp[i][col]+1);
                        }else {
                            dp[i+1][col] = dp[i][col];
                        }

                    }
                }
            }
        }
        if(dp[N][T.length()] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N][T.length()]);
        }
    }
}
