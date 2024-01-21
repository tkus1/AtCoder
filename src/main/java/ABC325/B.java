package src.main.java.ABC325;

import java.util.Scanner;

public class B {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[24];
        for (int i = 0; i < N; i++) {
            int W = scanner.nextInt();
            int X = scanner.nextInt();
            for (int j = 0; j < 24; j++) {
                if(9<(24 + j-X)% 24 && (24 + j-X)% 24 <= 18){
                    A[j] += W;
                }
            }

        }
        int ans = 0;
        for (int i =0; i < 24; i++) {
            ans = Math.max(ans, A[i]);
        }
        System.out.println(ans);
    }

}
