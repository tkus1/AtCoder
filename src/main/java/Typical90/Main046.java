package src.main.java.Typical90;

import java.util.HashMap;
import java.util.Scanner;

public class Main046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        final int MOD = 46;
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        HashMap<Integer, Integer> mapC = new HashMap<>();

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            C[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int modA = A[i] % MOD;
            int modB = B[i] % MOD;
            int modC = C[i] % MOD;
            // A
            mapA.merge(modA, 1, Integer::sum);
            // B
            mapB.merge(modB, 1, Integer::sum);
            // C
            mapC.merge(modC, 1, Integer::sum);
        }
        long ans = 0;
        for(int keyA: mapA.keySet()){
            for(int keyB: mapB.keySet()){
                for(int keyC: mapC.keySet()){
                    if((keyA + keyB + keyC) % MOD == 0){
                        int countA = mapA.get(keyA);
                        int countB = mapB.get(keyB);
                        int countC = mapC.get(keyC);
                        ans += ((long) countA * countB * countC);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
