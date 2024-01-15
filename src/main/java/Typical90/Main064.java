package src.main.java.Typical90;

import java.util.Scanner;

public class Main064{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        long[] A = new long[N];
        long[] diffLeftFromRight = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }
        for (int i = 1; i < N; i++) {
            diffLeftFromRight[i] = A[i] - A[i-1];
        }
        long inconveniences = 0;
        for (int i = 1; i < N; i++) {
            inconveniences += Math.abs(diffLeftFromRight[i]);
        }
        for (int i = 0; i < Q; i++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            long V = scanner.nextLong();
            long leftInconvenienceDelta;
            if(L == 1){
                leftInconvenienceDelta = 0;
            }else {
                long prevDiffLeft = diffLeftFromRight[L - 1];
                diffLeftFromRight[L - 1] += V;
                leftInconvenienceDelta = Math.abs(diffLeftFromRight[L - 1]) - Math.abs(prevDiffLeft);
            }
            long rightInconvenienceDelta;
            if(R == N){
                rightInconvenienceDelta = 0;
            }else{
                long prevDiffRight = diffLeftFromRight[R];
                diffLeftFromRight[R] -= V;
                rightInconvenienceDelta = Math.abs(diffLeftFromRight[R]) - Math.abs(prevDiffRight);
            }
            inconveniences += leftInconvenienceDelta + rightInconvenienceDelta;
            System.out.println(inconveniences);
        }

    }
}
