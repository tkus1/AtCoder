package src.main.java.AlgorithmAndMath;

import java.util.ArrayList;
import java.util.Scanner;

public class Main038 {

    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int[] A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = scanner.nextInt();
        }
        int[] L = new int[Q];
        int[] R = new int[Q];
        for (int i = 0; i < Q; i++) {
            L[i] = scanner.nextInt();
            R[i] = scanner.nextInt();
        }
        long[] sumArray = new long[N+1];
        sumArray[0] = 0;
        for (int i = 1; i <= N; i++) {
            sumArray[i] = sumArray[i-1] + A[i];
        }
        long[] resultArray = new long[Q];
        for (int i = 0; i < Q; i++) {
            long total = sumArray[R[i]] - sumArray[L[i]-1];
            resultArray[i] = total;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (long resTotal : resultArray){
            stringBuilder.append(resTotal).append("\n");
        }

        System.out.println(stringBuilder);

    }
}
