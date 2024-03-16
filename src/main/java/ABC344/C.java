package src.main.java.ABC344;

import java.util.HashSet;
import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        int M = scanner.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = scanner.nextInt();
        }
        int L = scanner.nextInt();
        int[] C = new int[L];
        for (int i = 0; i < L; i++) {
            C[i] = scanner.nextInt();
        }
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < L; k++) {
                    map.add(A[i] + B[j] + C[k]);
                }
            }
        }
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int X = scanner.nextInt();
            System.out.println(map.contains(X) ? "Yes" : "No");
        }

    }
}
