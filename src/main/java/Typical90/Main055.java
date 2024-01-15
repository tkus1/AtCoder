package src.main.java.Typical90;

import java.util.Scanner;

public class Main055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int P = scanner.nextInt();
        int Q = scanner.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong() % P;
        }
        int ans = 0;
        for (int i = 0; i < N-4; i++) {
            for (int j = i+1; j <N-3; j++) {
                long i_j = (int) ((A[i] * A[j]) % P);
                for (int k = j+1; k <N-2; k++) {
                    long i_j_k = (int) ((i_j * A[k]) % P);
                    for (int l = k+1; l <N-1 ; l++) {
                        long i_j_k_l = (int) ((i_j_k * A[l]) % P);
                        for (int m = l+1; m <N ; m++) {
                            if(i_j_k_l * A[m] % P == Q) {
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
